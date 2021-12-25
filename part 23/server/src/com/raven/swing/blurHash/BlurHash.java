package com.raven.swing.blurHash;

import java.awt.image.BufferedImage;

public class BlurHash {

    private BlurHash() {
    }

    public static String encode(BufferedImage bufferedImage) {
        return encode(bufferedImage, 4, 3);
    }

    public static String encode(BufferedImage bufferedImage, int componentX, int componentY) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int[] pixels = bufferedImage.getRGB(0, 0, width, height, null, 0, width);
        return encode(pixels, width, height, componentX, componentY);
    }

    public static String encode(int[] pixels, int width, int height, int componentX, int componentY) {
        if (componentX < 1 || componentX > 9 || componentY < 1 || componentY > 9) {
            throw new IllegalArgumentException("x and y component counts must be between 1 and 9 inclusive.");
        }
        if (width * height != pixels.length) {
            throw new IllegalArgumentException("Width and height must match the pixels array");
        }

        double[][] factors = new double[componentX * componentY][3];
        for (int j = 0; j < componentY; j++) {
            for (int i = 0; i < componentX; i++) {
                double normalisation = i == 0 && j == 0 ? 1 : 2;
                Util.applyBasisFunction(pixels, width, height,
                        normalisation, i, j,
                        factors, j * componentX + i);
            }
        }

        int factorsLength = factors.length;
        char[] hash = new char[4 + 2 * factorsLength];

        long sizeFlag = componentX + componentY * 9 - 10;
        Base83.encode(sizeFlag, 1, hash, 0);

        double maximumValue;
        if (factorsLength > 1) {
            double actualMaximumValue = Util.max(factors);
            double quantisedMaximumValue = Math.floor(Math.max(0, Math.min(82, Math.floor(actualMaximumValue * 166 - 0.5))));
            maximumValue = (quantisedMaximumValue + 1) / 166;
            Base83.encode(Math.round(quantisedMaximumValue), 1, hash, 1);
        } else {
            maximumValue = 1;
            Base83.encode(0, 1, hash, 1);
        }

        double[] dc = factors[0];
        Base83.encode(Util.encodeDC(dc), 4, hash, 2);

        for (int i = 1; i < factorsLength; i++) {
            Base83.encode(Util.encodeAC(factors[i], maximumValue), 2, hash, 4 + 2 * i);
        }
        return new String(hash);
    }

    public static BufferedImage decodeAndDraw(String blurHash, int width, int height, double punch, int bufferedImageType) {
        int[] data = decode(blurHash, width, height, punch);
        BufferedImage image = new BufferedImage(width, height, bufferedImageType);
        image.setRGB(0, 0, width, height, data, 0, width);
        return image;
    }

    public static int[] decode(String blurHash, int width, int height, double punch) {
        int blurHashLength = blurHash.length();
        if (blurHashLength < 6) {
            throw new IllegalArgumentException("BlurHash must be at least 6 characters long.");
        }

        //Decode metadata
        int sizeInfo = Base83.decode(blurHash.substring(0, 1));
        int sizeY = sizeInfo / 9 + 1;
        int sizeX = sizeInfo % 9 + 1;

        //Make sure we at least have the right number of characters
        if (blurHashLength != 4 + 2 * sizeX * sizeY) {
            throw new IllegalArgumentException("Invalid BlurHash length.");
        }

        int quantMaxValue = Base83.decode(blurHash.substring(1, 2));
        double realMaxValue = (quantMaxValue + 1) / 166.0 * punch;

        //Decode DC component
        double[][] colors = new double[sizeX * sizeY][3];
        Util.decodeDC(blurHash.substring(2, 6), colors[0]);

        //Decode AC components
        for (int i = 1; i < sizeX * sizeY; i++) {
            Util.decodeAC(blurHash.substring(4 + i * 2, 6 + i * 2), realMaxValue, colors[i]);
        }

        int[] pixels = new int[width * height];
        int pos = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                double r = 0, g = 0, b = 0;
                for (int y = 0; y < sizeY; y++) {
                    for (int x = 0; x < sizeX; x++) {
                        double basic = Math.cos(Math.PI * x * i / width)
                                * Math.cos(Math.PI * y * j / height);
                        double[] color = colors[x + y * sizeX];
                        r += (color[0] * basic);
                        g += (color[1] * basic);
                        b += (color[2] * basic);
                    }
                }

                pixels[pos++] = 255 << 24 | (SRGB.fromLinear(r) & 255) << 16
                        | (SRGB.fromLinear(g) & 255) << 8 | (SRGB.fromLinear(b) & 255);
            }
        }

        return pixels;
    }
}

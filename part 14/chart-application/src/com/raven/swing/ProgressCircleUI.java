package com.raven.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressCircleUI extends BasicProgressBarUI {

    private final Progress pro;
    private final Image imageDown;
    private final Image imageCancel;
    private final Image imageFile;

    public ProgressCircleUI(Progress pro) {
        this.pro = pro;
        imageDown = new ImageIcon(getClass().getResource("/com/raven/icon/down.png")).getImage();
        imageCancel = new ImageIcon(getClass().getResource("/com/raven/icon/cancel.png")).getImage();
        imageFile = new ImageIcon(getClass().getResource("/com/raven/icon/file.png")).getImage();
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Insets b = progressBar.getInsets(); // area for border
        int barRectWidth = progressBar.getWidth() - b.right - b.left;
        int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        // draw the cells
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(new Color(60, 60, 60, 50));
        g2.fillOval(0, 0, pro.getWidth(), pro.getHeight());
        if (pro.getProgressType() != Progress.ProgressType.NONE) {
            g2.drawImage(pro.getProgressType() == Progress.ProgressType.CANCEL ? imageCancel : pro.getProgressType() == Progress.ProgressType.DOWN_FILE ? imageDown : imageFile, 10, 10, pro.getWidth() - 20, pro.getHeight() - 20, null);
        }
        g2.setPaint(progressBar.getForeground());
        double degree = 360 * progressBar.getPercentComplete();
        double sz = Math.min(barRectWidth, barRectHeight);
        double cx = b.left + barRectWidth * .5;
        double cy = b.top + barRectHeight * .5;
        double or = sz * .5;
        double ir = or * .9; //or - 20;
        Shape inner = new Ellipse2D.Double(cx - ir, cy - ir, ir * 2, ir * 2);
        Shape outer = new Arc2D.Double(
                cx - or, cy - or, sz, sz, 90 - degree, degree, Arc2D.PIE);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        g2.fill(area);
        g2.dispose();

        // Deal with possible text painting
        if (progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
        }
    }
}

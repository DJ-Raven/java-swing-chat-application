package com.raven.model;

public class Model_Reques_File {

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }

    public Model_Reques_File(int fileID, long currentLength) {
        this.fileID = fileID;
        this.currentLength = currentLength;
    }

    public Model_Reques_File() {
    }

    private int fileID;
    private long currentLength;
}

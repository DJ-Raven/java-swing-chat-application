package com.raven.model;

public class Model_Receive_Message {

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_Receive_Message(int fromUserID, String text) {
        this.fromUserID = fromUserID;
        this.text = text;
    }

    public Model_Receive_Message() {

    }

    private int fromUserID;
    private String text;
}

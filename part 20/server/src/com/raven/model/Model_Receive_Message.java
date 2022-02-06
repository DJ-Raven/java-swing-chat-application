package com.raven.model;

public class Model_Receive_Message {

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

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

    public Model_Receive_Message(int messageType, int fromUserID, String text) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.text = text;
    }

    public Model_Receive_Message() {
    }

    private int messageType;
    private int fromUserID;
    private String text;
}

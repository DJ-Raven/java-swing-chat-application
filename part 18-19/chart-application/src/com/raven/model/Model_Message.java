package com.raven.model;

public class Model_Message {

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Model_Message(boolean action, String message) {
        this.action = action;
        this.message = message;
    }

    public Model_Message() {
    }

    private boolean action;
    private String message;
}

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Model_Message(boolean action, String message, Object data) {
        this.action = action;
        this.message = message;
        this.data = data;
    }

    public Model_Message() {
    }

    private boolean action;
    private String message;
    private Object data;
}

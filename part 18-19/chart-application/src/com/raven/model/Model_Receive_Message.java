package com.raven.model;

import org.json.JSONException;
import org.json.JSONObject;

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

    public Model_Receive_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private int fromUserID;
    private String text;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("text", text);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}

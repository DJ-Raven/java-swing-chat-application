package com.raven.event;

import com.raven.model.Model_Receive_Message;
import com.raven.model.Model_Send_Message;

public interface EventChat {

    public void sendMessage(Model_Send_Message data);

    public void receiveMessage(Model_Receive_Message data);
}

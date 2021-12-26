package com.raven.event;

import java.io.File;

public interface EventFileReceiver {

    public void onReceiving(double percentage);

    public void onStartReceiving();

    public void onFinish(File file);
}

package com.androidunleashed.createserviceapp;

import android.app.Service;
import android.content.Intent;
import android.widget.Toast;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

public class HandleService extends Service {
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle fromActivity=msg.getData();
            if(fromActivity !=null) { 
                String     username=fromActivity.getString("username");
                Toast.makeText(HandleService.this, "Welcome "+username, Toast.LENGTH_LONG).show();
            } 
            super.handleMessage(msg);
        }
    }

    final Messenger messengerToService = new Messenger(new IncomingHandler());
    @Override
    public IBinder onBind(Intent arg0) {
        return messengerToService.getBinder();
    }
}

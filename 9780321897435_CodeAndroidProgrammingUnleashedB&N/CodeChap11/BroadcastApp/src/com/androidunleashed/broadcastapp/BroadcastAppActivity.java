package com.androidunleashed.broadcastapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class BroadcastAppActivity extends Activity {
    public static String BROADCAST_STRING = "com.androidunleashed.testingbroadcast";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_app);
        Button broadcastButton = (Button) this.findViewById(R.id.broadcast_button);
        broadcastButton.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra("message", "New Email arrived");
                broadcastIntent.setAction(BROADCAST_STRING); 
                sendBroadcast(broadcastIntent);
            }
        });
    }
}

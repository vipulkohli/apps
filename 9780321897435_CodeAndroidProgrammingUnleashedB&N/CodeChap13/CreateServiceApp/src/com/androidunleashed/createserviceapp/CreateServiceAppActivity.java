package com.androidunleashed.createserviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.os.Messenger;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.content.ComponentName;
import android.os.Message;
import android.os.RemoteException;
import android.content.Context;

public class CreateServiceAppActivity extends Activity {
    private Messenger messengerToService = null;
    boolean mBound;

    private ServiceConnection servConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            messengerToService=new Messenger(service);
            mBound=true;
        }
        @Override 
        public void onServiceDisconnected (ComponentName className) {
            messengerToService = null;
            mBound=false;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service_app);
        Button submitButton  = (Button)findViewById(R.id.submit_button);
        submitButton .setOnClickListener(new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            Message msg = Message.obtain();
            Bundle dataBundle = new Bundle(); 
            EditText username = (EditText) findViewById(R.id.username);
            dataBundle.putString("username", username.getText().toString());
            msg.setData(dataBundle);
            try {
                messengerToService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }    
        }
    });   
    } 

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setAction("com.androidunleashed.handleservice");
        bindService(new Intent(this, HandleService.class), servConn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(servConn);
            mBound = false;
        }
    }
}

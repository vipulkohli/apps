package com.androidunleashed.phonecallapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.util.Log;

public class PhoneCallAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call_app);      
        MyPhoneCallListener phoneListener = new MyPhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager)  getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);
        Button callButton = (Button) findViewById(R.id.callbutton);
        callButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1111122222"));
                startActivity(callIntent);    
            }
        });
    }

    class MyPhoneCallListener extends PhoneStateListener {
        TextView messageview = (TextView)findViewById(R.id.messageview);   
        String msg;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE:
                    msg= "Call state is idle";
                    Log.d("idle", msg);
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    msg = "Call state is Ringing. Number is "+ incomingNumber;
                    Log.d("ringing", msg);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    msg = "Call state is OFFHOOK";
                    Log.d("offhook", msg);
                    break;
                default:
                    msg = "Call state is" + state + ". Number is " + incomingNumber;
                    Log.d("state", msg);
                    break;
            }
            messageview.setText(msg);
            
        }
    }
}

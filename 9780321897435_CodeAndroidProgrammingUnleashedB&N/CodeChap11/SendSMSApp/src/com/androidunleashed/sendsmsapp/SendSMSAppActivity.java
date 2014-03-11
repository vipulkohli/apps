package com.androidunleashed.sendsmsapp;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;

public class SendSMSAppActivity extends Activity {
    EditText phoneNumber, message;
    BroadcastReceiver sentReceiver, deliveredReceiver;
    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED"; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsapp);
        final PendingIntent sentPendIntent = PendingIntent.getBroadcast(this, 0, new  Intent(SENT), 0);
        final PendingIntent delivered_pendintnet = PendingIntent.getBroadcast(this, 0,  new Intent(DELIVERED), 0);
        sentReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service",  Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off",  Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        deliveredReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS successfully delivered",  Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "Failure—SMS not delivered",  Toast.LENGTH_SHORT).show();
                        break;   
                }
            }
        };
        registerReceiver(sentReceiver, new IntentFilter(SENT));
        registerReceiver(deliveredReceiver, new IntentFilter(DELIVERED));
        Button sendBtn = (Button) this.findViewById(R.id.send_button);
        sendBtn.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                phoneNumber = (EditText) findViewById(R.id.recvr_no);
                message = (EditText) findViewById(R.id.txt_msg);
                if(phoneNumber.getText().toString().trim().length() >0 && message.getText().toString().trim().length() >0) {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phoneNumber.getText().toString(), null, 
                    message.getText().toString(), sentPendIntent, delivered_pendintnet);
                }
                else {
                    Toast.makeText(SendSMSAppActivity.this, "Either phone number or text is  missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button cancelBtn = (Button) this.findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                phoneNumber.setText("");
                message.setText("");
            }
        });
    }
}

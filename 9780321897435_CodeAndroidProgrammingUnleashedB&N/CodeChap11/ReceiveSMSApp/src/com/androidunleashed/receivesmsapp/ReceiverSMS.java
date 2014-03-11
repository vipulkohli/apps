package com.androidunleashed.receivesmsapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class ReceiverSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();  
        SmsMessage[] msg = null;
        String str = "";  
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            msg = new SmsMessage[pdus.length];   
            for (int i=0; i<msg.length; i++){
                msg[i] = SmsMessage.createFromPdu((byte[])pdus[i]);  
                str += "SMS Received from: " + msg[i].getOriginatingAddress();  
                str += ":";
                str += msg[i].getMessageBody().toString();
                str += "\n";        
            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        }                         
    }
}

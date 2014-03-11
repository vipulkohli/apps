package com.androidunleashed.receivesmsapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReceiveSMSAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_smsapp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_receive_smsapp, menu);
        return true;
    }
}

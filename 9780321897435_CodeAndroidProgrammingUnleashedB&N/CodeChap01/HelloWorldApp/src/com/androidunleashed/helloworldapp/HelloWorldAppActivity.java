package com.androidunleashed.helloworldapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class HelloWorldAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world_app);
        TextView mesg = (TextView)findViewById(R.id.message);   
        mesg.setText("Hello World!");                          
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hello_world_app, menu);
        return true;
    }
}

package com.androidunleashed.welcomemsg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class WelcomeMsgActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_msg);
    }
    public void dispMessage(View v) 
        {
          EditText name = (EditText) findViewById(R.id.user_name);
          String str = "Welcome " + name.getText().toString() + " !";
           Toast.makeText(WelcomeMsgActivity.this, str, Toast.LENGTH_SHORT).show();
        } 

}

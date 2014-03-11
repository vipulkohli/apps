package com.androidunleashed.welcomeapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class WelcomeAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_app);
        startActivity(new Intent(this, Welcome.class));
    }
}

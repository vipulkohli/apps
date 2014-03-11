package com.androidunleashed.absolutelayoutapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AbsoluteLayoutAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_layout_app);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_absolute_layout_app, menu);
        return true;
    }
}

package com.androidunleashed.listfragapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListFragAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_frag_app);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_frag_app, menu);
        return true;
    }
}

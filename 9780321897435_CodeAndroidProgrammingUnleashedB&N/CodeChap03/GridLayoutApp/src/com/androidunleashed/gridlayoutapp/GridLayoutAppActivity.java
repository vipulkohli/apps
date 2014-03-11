package com.androidunleashed.gridlayoutapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GridLayoutAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_app);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_grid_layout_app, menu);
        return true;
    }
}

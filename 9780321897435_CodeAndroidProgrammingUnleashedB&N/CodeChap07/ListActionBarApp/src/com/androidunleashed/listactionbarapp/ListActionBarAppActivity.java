package com.androidunleashed.listactionbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar;
import android.widget.ArrayAdapter;
import android.util.Log;

public class ListActionBarAppActivity extends Activity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] items = new String[] { "Create", "Insert", "Update", "Search" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);   
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(adapter, onNavigationItemSelected);
   //     actionBar.setBackgroundDrawable(new ColorDrawable("#00FF00")); 

    }
   
    OnNavigationListener onNavigationItemSelected = new OnNavigationListener() {
        @Override
        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
            Log.d("Option ", String.valueOf(itemId) + " is selected");
            return true;
        }
    }; 
}


package com.androidunleashed.tabbedactionbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.util.Log;

public class TabbedActionBarAppActivity extends Activity implements ActionBar.TabListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.addTab(actionBar.newTab().setText("Create").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Update").setTabListener(this));  
    }

    @Override
       public void onTabReselected(Tab tab, FragmentTransaction ft) {
               Log.d("Tab", String.valueOf(tab.getPosition()) + " re-selected");
       }

       @Override
       public void onTabSelected(Tab tab, FragmentTransaction ft) {
       Log.d("Tab", String.valueOf(tab.getPosition()) + " selected");
       }

       @Override
       public void onTabUnselected(Tab tab, FragmentTransaction ft) {
     Log.d("Tab", String.valueOf(tab.getPosition()) + " Unselected");
       }
    }

package com.androidunleashed.actionbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ActionBarAppActivity extends Activity {
    private TextView selectedOpt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_app);
        selectedOpt=(TextView)findViewById(R.id.selectedopt);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_action_bar_app, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_datab: 
                selectedOpt.setText("You have selected Create Database option");
                break;
            case R.id.insert_rows: 
                selectedOpt.setText("You have selected Insert Rows option");
                break;
            case R.id.list_rows: 
                selectedOpt.setText("You have selected List Rows option");
                break;
            case R.id.search_row: 
                selectedOpt.setText("You have selected Search Row option");
                break;
            case R.id.delete_row: 
                selectedOpt.setText("You have selected Delete Row option");
                break;
            case R.id.update_row: 
                selectedOpt.setText("You have selected Update Row option");
                break;         
            case R.id.search_code: 
                selectedOpt.setText("You have selected Search on Code option");
                break;
            case R.id.search_name: 
                selectedOpt.setText("You have selected Search on Name option");
                break;
            case R.id.search_price: 
                selectedOpt.setText("You have selected Search on Price option");
                break;        
        }
        return true;
    } 
}

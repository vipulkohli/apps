package com.androidunleashed.spinnerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_app);
        final TextView selectedOpt=(TextView)findViewById(R.id.selectedopt);
        final String[] fruits={"Apple", "Mango", "Orange", "Grapes", "Banana"};
        Spinner spin=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdpt=new ArrayAdapter<String>(this, 
                android.R.layout.simple_spinner_item, fruits);
            spin.setAdapter(arrayAdpt);   
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View v, int position, 
                long id) {
                selectedOpt.setText("You have selected " +fruits[position]);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                selectedOpt.setText("");
            }
        });
    }
}

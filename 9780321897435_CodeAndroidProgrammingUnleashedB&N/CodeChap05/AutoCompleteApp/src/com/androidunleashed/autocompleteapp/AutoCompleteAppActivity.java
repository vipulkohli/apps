package com.androidunleashed.autocompleteapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteAppActivity extends Activity {       
    @Override
    public void onCreate(Bundle savedInstanceState) {
        String[] products ={"Camera","Handi Cam","Cell phone","Laptop","Car"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_app);
        ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, 
            android.R.layout.simple_dropdown_item_1line, products);
        AutoCompleteTextView productNames = (AutoCompleteTextView) findViewById(R.id.product_names);
        productNames.setThreshold(1);
        productNames.setAdapter(arrayAdapt);   
    }
}

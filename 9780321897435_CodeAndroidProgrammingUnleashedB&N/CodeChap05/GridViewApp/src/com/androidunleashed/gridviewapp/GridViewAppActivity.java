package com.androidunleashed.gridviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;

public class GridViewAppActivity extends Activity implements 
    AdapterView.OnItemClickListener {
    TextView selectedOpt; 
    String[] fruits={"Apple", "Mango", "Banana", "Grapes", "Orange",  "Pineapple",      
       "Strawberry", "Papaya", "Guava", "Pomegranate",  "Watermelon", "Chickoo", "Dates", 
       "Plum", "Cherry", "Kiwi"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_app);
        selectedOpt=(TextView) findViewById(R.id.selectedopt); 
        GridView g=(GridView) findViewById(R.id.grid); 
        ArrayAdapter<String> arrayAdpt=new ArrayAdapter<String> (this, 
            android.R.layout.simple_list_item_1, fruits);
        g.setAdapter(arrayAdpt);  
        g.setOnItemClickListener(this);
    }
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        selectedOpt.setText("You have selected "+fruits[position]);
    } 
    
    public void onNothingSelected(AdapterView<?> parent) {
        selectedOpt.setText("");
    }
}

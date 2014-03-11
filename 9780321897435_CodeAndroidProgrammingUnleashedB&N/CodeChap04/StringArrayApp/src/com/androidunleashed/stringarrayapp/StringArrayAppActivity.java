package com.androidunleashed.stringarrayapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StringArrayAppActivity extends Activity {  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_array_app);
        TextView oddNumsView = (TextView)findViewById(R.id.oddnums_view);
        int[] oddNumsArray = getResources().getIntArray(R.array.OddNumbers);
        String str = "";
        for(int i = 0; i < oddNumsArray.length; i++){
            str += oddNumsArray[i] + "\n";
        }
        oddNumsView.setText(str);
    }
}

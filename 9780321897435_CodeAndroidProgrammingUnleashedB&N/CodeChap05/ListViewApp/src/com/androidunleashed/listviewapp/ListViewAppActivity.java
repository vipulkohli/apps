package com.androidunleashed.listviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;

public class ListViewAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_app);
        final String[] fruitsArray = getResources().getStringArray(R.array.fruits);
        final TextView selectedOpt=(TextView)findViewById(R.id.selectedopt);
        ListView fruitsList = (ListView)findViewById(R.id.fruits_list);
        fruitsList.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedOpt.setText("You have selected "+fruitsArray[position]);
            }
        });
    }
}

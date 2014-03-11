package com.androidunleashed.createcontentproviderapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.ContentValues;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

public class CreateContentProviderAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content_provider_app);
        Button addStdButton = (Button)this.findViewById(R.id.add_stdinfo);
        addStdButton.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues(); 
                contentValues.put(CountriesProvider.COUNTRY, ((EditText) findViewById(R.id.country_name)).getText().toString());
                contentValues.put(CountriesProvider.STDCODE, ((EditText) findViewById(R.id.std_code)).getText().toString());
                getContentResolver().insert(CountriesProvider.CONTENT_URI, contentValues);
                ((EditText) findViewById(R.id.country_name)).setText(""); 
                ((EditText) findViewById(R.id.std_code)).setText(""); 
                Toast.makeText(CreateContentProviderAppActivity.this, "Row inserted", Toast.LENGTH_SHORT).show();
            } 
        });           

        Button listStdButton = (Button)this.findViewById(R.id.list_stdinfo);
        listStdButton.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                startActivity(new Intent(CreateContentProviderAppActivity.this, ShowSTDActivity.class));
            } 
        });     
    }
}

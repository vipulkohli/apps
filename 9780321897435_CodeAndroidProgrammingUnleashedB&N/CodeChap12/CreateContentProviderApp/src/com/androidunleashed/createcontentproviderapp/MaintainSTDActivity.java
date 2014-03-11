package com.androidunleashed.createcontentproviderapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;
import android.net.Uri;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.Toast;

public class MaintainSTDActivity extends Activity {
    EditText countryName , stdCode ;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintainstd);  
        countryName  = (EditText) findViewById(R.id.country_name);
        stdCode  = (EditText) findViewById(R.id.std_code);
        Bundle extras = getIntent().getExtras();
        uri = (extras == null) ? null: (Uri) extras.getParcelable(CountriesProvider.CONTENT_ITEM_TYPE);
        if (extras != null) {
            uri = extras.getParcelable(CountriesProvider.CONTENT_ITEM_TYPE);
            String[] projection = new String[] {CountriesProvider.ID, CountriesProvider.COUNTRY, CountriesProvider.STDCODE} ;  
            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                countryName .setText(cursor.getString(cursor.getColumnIndexOrThrow
(CountriesProvider.COUNTRY)));
                stdCode .setText(cursor.getString(cursor.getColumnIndexOrThrow
(CountriesProvider.STDCODE)));
                cursor.close();
            }
        }
        Button deleteStdInfo  = (Button) findViewById(R.id.delete_stdinfo);
        Button updateStdInfo = (Button) findViewById(R.id.update_stdinfo);
        deleteStdInfo .setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                int count = getContentResolver().delete(uri, null, null);
                if(count >0)
                    Toast.makeText(MaintainSTDActivity.this, "Row deleted", Toast.LENGTH_SHORT).show(); 
            } 
        });    

        updateStdInfo.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues(); 
                contentValues.put(CountriesProvider.COUNTRY, countryName .getText().toString());
                contentValues.put(CountriesProvider.STDCODE, stdCode .getText().toString());
                getContentResolver().update(uri, contentValues,null,null);
                Toast.makeText(MaintainSTDActivity.this, "Row updated", Toast.LENGTH_SHORT).show(); 
            } 
        });    
    } 
}

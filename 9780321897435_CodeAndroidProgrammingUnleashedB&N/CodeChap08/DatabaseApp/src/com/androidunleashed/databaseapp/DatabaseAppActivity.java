package com.androidunleashed.databaseapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;



public class DatabaseAppActivity extends Activity {
    private DatabaseManager mydManager;
    private TextView response;
    private ListView productRec;
    EditText pcode, pname, price;
    Button addButton;
    private TableLayout addLayout;
    private boolean recInserted;
    ArrayList<String> tableContent; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_app);
        response=(TextView)findViewById(R.id.response);
        productRec=(ListView)findViewById(R.id.prodrec);
        addLayout=(TableLayout)findViewById(R.id.add_table);
        addLayout.setVisibility(View.GONE);
        response.setText("Press MENU button to display menu");     
        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mydManager = new DatabaseManager(DatabaseAppActivity.this);
                pcode=(EditText)findViewById(R.id.prod_code);
                pname=(EditText)findViewById(R.id.prod_name);
                price=(EditText)findViewById(R.id.prod_price);
                recInserted=mydManager.addRow(Integer.parseInt(pcode.getText().toString()), pname.getText().toString(), 
                Float.parseFloat (price.getText().toString()));
                addLayout.setVisibility(View.GONE);    
                if(recInserted)
                    response.setText("The row in the products table is inserted");
                else
                    response.setText("Sorry, some errors occurred while inserting the row in the products table");    
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); 
                imm.hideSoftInputFromWindow(price.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS); 
                mydManager.close();
                pcode.setText("");
                pname.setText("");
                price.setText("");
                productRec.setVisibility(View.GONE);  
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_database_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {        
            case R.id.insert_rows: addLayout.setVisibility(View.VISIBLE);
                response.setText("Enter information of the new product");
                productRec.setVisibility(View.GONE);
                break;
            case R.id.list_rows: showRec();
                break;         
        }
        return true;
    } 

    public boolean showRec(){
        addLayout.setVisibility(View.GONE);
        mydManager = new DatabaseManager(this);
        mydManager.openReadable();
        tableContent = mydManager.retrieveRows();
        response.setText("The rows in the products table are:");
        productRec = (ListView)findViewById(R.id.prodrec);        
        ArrayAdapter<String> arrayAdpt=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContent);
        productRec.setAdapter(arrayAdpt);  
        productRec.setVisibility(View.VISIBLE);
        mydManager.close();
        return true;
    }   
}

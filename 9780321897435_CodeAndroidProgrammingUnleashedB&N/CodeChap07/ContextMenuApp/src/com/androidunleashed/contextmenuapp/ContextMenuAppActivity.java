package com.androidunleashed.contextmenuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.TextView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ContextMenu;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class ContextMenuAppActivity extends Activity {
    private TextView selectedOpt;
    String[] fruits={"Apple", "Mango", "Orange", "Grapes", "Banana"};
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_app);
        selectedOpt=(TextView)findViewById(R.id.selectedopt);
        selectedOpt.setText("Tap and hold a menu item to display its context menu");
        ListView myListView = (ListView)findViewById(R.id.listvw);
        final ArrayAdapter<String> arrayAdpt= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits);
        myListView.setAdapter(arrayAdpt);  
        registerForContextMenu(myListView);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
    {    
        super.onCreateContextMenu(menu, v, menuInfo); 
        if(v.getId()==R.id.listvw)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            if(fruits[info.position]=="Apple")
            {
                menu.setHeaderTitle(fruits[info.position]);
                MenuInflater inflater = getMenuInflater();     
                inflater.inflate(R.menu.mycontext_menu1, menu); 
            }
            if(fruits[info.position]=="Mango")
            {
                menu.setHeaderTitle(fruits[info.position]);
                MenuInflater inflater = getMenuInflater();     
                inflater.inflate(R.menu.mycontext_menu2, menu); 
            }    
        }       
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {  
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) { 
            case R.id.cut_item:
                selectedOpt.setText("You have selected the Cut option of " + fruits[info.position]+" menu");
                break;
            case R.id.copy_item: 
                selectedOpt.setText("You have selected the Copy option of " + fruits[info.position]+" menu");
                break; 
            case R.id.open_item:
                selectedOpt.setText("You have selected the Open option of " + fruits[info.position]+" menu");
                break;
            case R.id.close_item: 
                selectedOpt.setText("You have selected the Close option of the " + fruits[info.position]+" menu");
                break; 
        }
        return true; 
    }
}

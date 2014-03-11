package com.androidunleashed.menuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.TextView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ContextMenu;

public class MenuAppActivity extends Activity {
    private TextView selectedOpt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        selectedOpt=(TextView)findViewById(R.id.selectedopt);
        selectedOpt.setText("Please select MENU button to display menu");
        TextView contxt1View=(TextView)findViewById(R.id.contxt1_view);
        TextView contxt2View=(TextView)findViewById(R.id.contxt2_view);
        registerForContextMenu(contxt1View);
        registerForContextMenu(contxt2View);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_app, menu);
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
            case R.id.sort_rows: 
                selectedOpt.setText("You have selected Sort Table option");
                item.setChecked(!item.isChecked());
                break;
            case R.id.merge_row: 
                selectedOpt.setText("You have selected Merge Rows option");
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
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
    {    
        super.onCreateContextMenu(menu, v, menuInfo); 
        if (v.getId()==R.id.contxt1_view)
        {    
            MenuInflater inflater = getMenuInflater();     
            inflater.inflate(R.menu.mycontext_menu1, menu); 
            menu.setHeaderTitle("Sample Context Menu1");
            menu.setHeaderIcon(R.drawable.ic_launcher);
        }
        if (v.getId()==R.id.contxt2_view)
        {       
            MenuInflater inflater = getMenuInflater();     
            inflater.inflate(R.menu.mycontext_menu2, menu); 
            menu.setHeaderTitle("Sample Context Menu2");
            menu.setHeaderIcon(R.drawable.ic_launcher);
        }
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {  
        switch (item.getItemId()) { 
            case R.id.cut_item:
                selectedOpt.setText("You have selected the Cut option");
                item.setChecked(!item.isChecked());
                break;
            case R.id.copy_item: 
                selectedOpt.setText("You have selected the Copy option");
                item.setChecked(!item.isChecked());
                break; 
            case R.id.find_item: 
                selectedOpt.setText("You have selected the Find Submenu");   
                break;
            case R.id.find_next: 
                selectedOpt.setText("You have selected the Find Next option");   
                break;
            case R.id.open_item:
                selectedOpt.setText("You have selected the Open option");
                break;
            case R.id.close_item: 
                selectedOpt.setText("You have selected the Close option");
                item.setChecked(!item.isChecked());
                break; 
        }
        return true; 
    }

}

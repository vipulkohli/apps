package com.androidunleashed.menuappcode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu;

public class MenuAppCodeActivity extends Activity {
     private static final int CREATE_DATAB = Menu.FIRST; 
     private static final int INSERT_ROWS = Menu.FIRST + 1; 
     private static final int LIST_ROWS = Menu.FIRST+2; 
     private static final int SEARCH_ROW = Menu.FIRST + 3; 
     private static final int DELETE_ROW = Menu.FIRST+4; 
     private static final int UPDATE_ROW = Menu.FIRST + 5; 
     private static final int SORT_ROWS = Menu.FIRST+6; 
     private static final int MERGE_ROW = Menu.FIRST + 7; 
     private static final int SEARCH_CODE = Menu.FIRST + 8; 
     private static final int SEARCH_NAME = Menu.FIRST + 9; 
     private static final int SEARCH_PRICE = Menu.FIRST + 10; 
     private static final int CUT_ITEM = Menu.FIRST + 11; 
     private static final int COPY_ITEM = Menu.FIRST + 12; 
     private static final int OPEN_ITEM = Menu.FIRST + 13; 
     private static final int CLOSE_ITEM = Menu.FIRST + 14;
     private static final int FIND_ITEM = Menu.FIRST + 15; 
     private static final int FIND_NEXT = Menu.FIRST + 16;
     private TextView selectedOpt;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app_code);
        selectedOpt=(TextView)findViewById(R.id.selectedopt);
        selectedOpt.setText("Please select MENU button to display menu");
        TextView contxt1View=(TextView)findViewById(R.id.contxt1_view);
        TextView contxt2View=(TextView)findViewById(R.id.contxt2_view);
        registerForContextMenu(contxt1View);
        registerForContextMenu(contxt2View);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,CREATE_DATAB,0,"Create Database").setIcon(R.drawable.ic_launcher); 
        menu.add(0,INSERT_ROWS,1,"Insert Rows").setIcon(R.drawable.ic_launcher);
        menu.add(0,LIST_ROWS,2,"List Rows");
        SubMenu searchSub = menu.addSubMenu(0, SEARCH_ROW, 3, "Search");
        menu.add(0,DELETE_ROW,4,"Delete");
        menu.add(0,UPDATE_ROW,5,"Update");
        menu.add(0,SORT_ROWS,6,"Sort Table").setCheckable(true).setChecked(true);
        menu.add(0,MERGE_ROW,7,"Merge Rows").setAlphabeticShortcut('m').setNumericShortcut('4');    
        searchSub.setHeaderIcon(R.drawable.ic_launcher);
        searchSub.setIcon(R.drawable.ic_launcher);
        searchSub.add(1, SEARCH_CODE, Menu.NONE, "Search on Code").setChecked(true);
        searchSub.add(1, SEARCH_NAME, Menu.NONE, "Search on Name").setShortcut('6', 'n');
        searchSub.add(1, SEARCH_PRICE, Menu.NONE, "Search on Price");
        searchSub.setGroupCheckable(1, true, true);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CREATE_DATAB: 
                selectedOpt.setText("You have selected Create Database option");
                break;
            case INSERT_ROWS: 
                selectedOpt.setText("You have selected Insert Rows option");
                break;
            case LIST_ROWS: 
                selectedOpt.setText("You have selected List Rows option");
                break;
            case SEARCH_ROW: 
                selectedOpt.setText("You have selected Search Submenu option");
                break;
            case DELETE_ROW: 
                selectedOpt.setText("You have selected Delete Row option");
                break;
            case UPDATE_ROW: 
                selectedOpt.setText("You have selected Update Row option");
                break;
            case SORT_ROWS: 
                selectedOpt.setText("You have selected Sort Table option");
                item.setChecked(!item.isChecked());
                break;
            case MERGE_ROW: 
                selectedOpt.setText("You have selected Merge Rows option");
                break;    
            case SEARCH_CODE: 
                selectedOpt.setText("You have selected Search on Code option");
                break;
            case SEARCH_NAME: 
                selectedOpt.setText("You have selected Search on Name option");
                break;
            case SEARCH_PRICE: 
                selectedOpt.setText("You have selected Search on Price option");
        }
        return true;
    } 
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.contxt1_view) {
            menu.setHeaderTitle("Sample Context Menu1");
            menu.setHeaderIcon(R.drawable.ic_launcher);
            menu.add(2, CUT_ITEM, Menu.NONE,"Cut");
            menu.add(2, COPY_ITEM, Menu.NONE, "Copy");
            menu.setGroupCheckable(2, true, false);
            SubMenu subcont = menu.addSubMenu(2, FIND_ITEM, Menu.NONE, "Find");
            subcont.add(3, FIND_NEXT, Menu.NONE, "Find Next");  
        }
        if (v.getId()==R.id.contxt2_view) {
            menu.setHeaderTitle("Sample Context Menu2");
            menu.setHeaderIcon(R.drawable.ic_launcher);
            menu.add(3, OPEN_ITEM, Menu.NONE, "Open").setShortcut('5', 'o');
            menu.add(3, CLOSE_ITEM, Menu.NONE, "Close").setCheckable(true);
        }
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {  
        switch (item.getItemId()) { 
            case CUT_ITEM:
                selectedOpt.setText("You have selected the Cut option");
                item.setChecked(!item.isChecked());
                break;
            case COPY_ITEM: 
                selectedOpt.setText("You have selected the Copy option");
                item.setChecked(!item.isChecked());
                break; 
            case FIND_ITEM: 
                selectedOpt.setText("You have selected the Find Submenu");   
                break;
            case FIND_NEXT: 
                selectedOpt.setText("You have selected the Find Next option");   
                break;
            case OPEN_ITEM:
                selectedOpt.setText("You have selected the Open option");
                break;
            case CLOSE_ITEM: 
                selectedOpt.setText("You have selected the Close option");
                item.setChecked(!item.isChecked());
                break; 
        } 
        return true; 
    }
}

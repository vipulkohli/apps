package com.androidunleashed.demoactionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;

public class DemoActionBarActivity extends Activity {
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_action_bar); 
        final ActionBar actionBar = getActionBar();
        Button showAction = (Button) this.findViewById(R.id.show_action);
        Button hideAction = (Button) this.findViewById(R.id.hide_action);
        Button showTitle = (Button) this.findViewById(R.id.show_title);
        Button hideTitle = (Button) this.findViewById(R.id.hide_title);
        Button showLogo = (Button) this.findViewById(R.id.show_logo);
        Button hideLogo = (Button) this.findViewById(R.id.hide_logo);
        
        showAction.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            {  actionBar.show();  }  });
        hideAction.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            {   actionBar.hide();    }   });
        showTitle.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            { actionBar.setDisplayShowTitleEnabled(true);   }  });
        hideTitle.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            {  actionBar.setDisplayShowTitleEnabled(false);  }  });
        showLogo.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            { actionBar.setDisplayShowHomeEnabled(true);  }  });
        hideLogo.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) 
            {  actionBar.setDisplayShowHomeEnabled(false); }  });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_demo_action_bar, menu);
        return true;
    } 

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_datab: 
                intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

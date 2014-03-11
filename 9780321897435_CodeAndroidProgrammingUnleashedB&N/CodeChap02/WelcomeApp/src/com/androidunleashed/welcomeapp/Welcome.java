package com.androidunleashed.welcomeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
 
public class Welcome extends Activity 
{
    @Override  
    protected void onCreate(Bundle savedInstanceState) 
    {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.welcome);     
          Button b = (Button)this.findViewById(R.id.click_btn);
          b.setOnClickListener(new Button.OnClickListener() { 
               public void onClick(View v) 
               {
                    TextView resp = (TextView) findViewById(R.id.response);
                    EditText name = (EditText) findViewById(R.id.user_name);
                    String str = "Welcome " + name.getText().toString() + " !";
                    resp.setText(str);             
               } 
          });
    }    
}

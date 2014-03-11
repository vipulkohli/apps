package com.androidunleashed.checkboxapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import android.view.View.OnClickListener;

public class CheckBoxAppActivity extends Activity implements OnClickListener {
     CheckBox c1,c2,c3;
        TextView resp;

     @Override
     public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_check_box_app);
          Button b = (Button)this.findViewById(R.id.bill_btn);
          resp = (TextView)this.findViewById(R.id.amount);
          c1 = (CheckBox)findViewById(R.id.checkbox_pizza);
          c2 = (CheckBox)findViewById(R.id.checkbox_hotdog);
          c3 = (CheckBox)findViewById(R.id.checkbox_burger);
          b.setOnClickListener(this); 
    }
    
     public void onClick(View v) {
          int amt=0;
          if (c1.isChecked()) {
               amt=amt+15;
          }
          if (c2.isChecked()) {
               amt=amt+5;
          }
          if (c3.isChecked()) {
               amt=amt+10;
          }
          resp.setText("Bill is " +Integer.toString(amt));
     }
}

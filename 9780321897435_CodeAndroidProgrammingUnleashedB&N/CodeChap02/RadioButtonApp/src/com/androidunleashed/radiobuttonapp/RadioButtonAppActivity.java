package com.androidunleashed.radiobuttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RadioButton;
import android.view.View;
import android.view.View.OnClickListener;

public class RadioButtonAppActivity extends Activity {
     String str1="";
     String str2="";
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_app);
        RadioButton radioFivestar = (RadioButton) findViewById(R.id.radio_fivestar);
        RadioButton radioThreestar = (RadioButton) findViewById(R.id.radio_threestar);
        RadioButton radioSuite = (RadioButton) findViewById(R.id.radio_suite);
        RadioButton radioLuxury = (RadioButton) findViewById(R.id.radio_luxury);
        RadioButton radioOrdinary = (RadioButton) findViewById(R.id.radio_ordinary);
        radioFivestar.setOnClickListener(radioListener1);
        radioThreestar.setOnClickListener(radioListener1);
        radioSuite.setOnClickListener(radioListener2);
        radioLuxury.setOnClickListener(radioListener2);
        radioOrdinary.setOnClickListener(radioListener2);
    }
    
    private OnClickListener radioListener1 = new OnClickListener() {
        public void onClick(View v) {
              TextView selectedOptions = (TextView) findViewById(R.id.hoteltype);
            RadioButton rb = (RadioButton) v;
            str1="The hotel type selected is: " +rb.getText();
            selectedOptions.setText(str1+"\n"+str2);         
        }
    };

    private OnClickListener radioListener2 = new OnClickListener() {
        public void onClick(View v) {
              TextView selectedOptions = (TextView) findViewById(R.id.hoteltype);
            RadioButton rb = (RadioButton) v;
            str2="Room type selected is: " +rb.getText();
            selectedOptions.setText(str1+"\n"+str2);        
        }
    };
}

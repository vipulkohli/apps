package com.androidunleashed.timepickerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TimePicker;

public class TimePickerAppActivity extends Activity {
    private TextView dispTime;
    private int h, m;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_app);
        dispTime = (TextView) findViewById(R.id.timevw);
        Button timeButton = (Button) findViewById(R.id.time_button);
        final Calendar c = Calendar.getInstance();
        h = c.get(Calendar.HOUR_OF_DAY);
        m = c.get(Calendar.MINUTE);
        dispTime.setText("Current time is: "+h+":"+m); 
        timeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(TimePickerAppActivity.this, timeListener, h,m,true).show();
            }
        });
    }
    
    private TimePickerDialog.OnTimeSetListener timeListener = new 
        TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hour, int minute) {
            h = hour;
            m = minute;
            dispTime.setText("Current time is: "+h+":"+m); 
        }
    };
}

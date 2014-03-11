package com.androidunleashed.datetimepickerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TimePicker;
import android.widget.DatePicker;
import java.text.DateFormat;

public class DateTimePickerAppActivity extends Activity {
    private TextView dateTimeView;
    private Calendar c;
    DateFormat DateTimeFormat = DateFormat.getDateTimeInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_app);
        dateTimeView = (TextView) findViewById(R.id.datetimevw);
        Button timeButton = (Button) findViewById(R.id.time_button);
        Button dateButton = (Button) findViewById(R.id.date_button);
        c = Calendar.getInstance();
        dateTimeView.setText(DateTimeFormat.format(c.getTime()));
        dateButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(DateTimePickerAppActivity.this, dateListener,c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
             }
        });
        timeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(DateTimePickerAppActivity.this, timeListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),true).show();
            }
        });
    }
    
    private DatePickerDialog.OnDateSetListener dateListener = new  DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) 
        {
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,monthOfYear);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            dateTimeView.setText(DateTimeFormat.format(c.getTime()));
        }
    };

    private TimePickerDialog.OnTimeSetListener timeListener = new 
        TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hour, int minute) {
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, minute);
            dateTimeView.setText(DateTimeFormat.format(c.getTime())); 
        }
    };                         
}

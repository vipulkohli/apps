package com.androidunleashed.datepickerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.DatePicker;

public class DatePickerAppActivity extends Activity {
    private TextView dispDate;
    private int yr, mon, dy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_app);
        dispDate = (TextView) findViewById(R.id.datevw);
        Button dateButton = (Button) findViewById(R.id.date_button);
        final Calendar c = Calendar.getInstance();
        yr = c.get(Calendar.YEAR);
        mon = c.get(Calendar.MONTH);
        dy = c.get(Calendar.DAY_OF_MONTH);
        dispDate.setText("Current date is: "+(mon+1)+"-"+dy+"-"+yr); 
        dateButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(DatePickerAppActivity.this, dateListener, yr, mon, dy).show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateListener = new 
        DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            yr = year;
            mon = monthOfYear;
            dy = dayOfMonth;
            dispDate.setText("Current date is: "+(mon+1)+"-"+dy+"-"+yr); 
        }
    };
}

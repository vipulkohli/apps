package com.androidunleashed.alarmapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;
import java.util.Calendar;
import android.widget.Toast;
import java.util.TimeZone;

public class AlarmAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_app);
        Button alarmButton = (Button) this.findViewById(R.id.alarm_button);
        alarmButton.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
            	 Intent myIntent = new Intent(AlarmAppActivity.this, ReminderActivity.class);
            	  PendingIntent pendingIntent = PendingIntent.getActivity(AlarmAppActivity.this, 0, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);
                  AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            	           Calendar calendar = Calendar.getInstance();
           	           calendar.setTimeInMillis(System.currentTimeMillis());
           	           calendar.add(Calendar.SECOND, 1);
        //      	           calendar.set(Calendar.HOUR_OF_DAY, 7);
        //   	           calendar.set(Calendar.MINUTE, 50);
        //   	        calendar.set(Calendar.SECOND, 0); 
       	          alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);  	
       //	        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5*1000, pendingIntent);
                 Toast.makeText(AlarmAppActivity.this, "Alarm is scheduled ", Toast.LENGTH_LONG).show();
            }
            	 });
            

    }
   
}

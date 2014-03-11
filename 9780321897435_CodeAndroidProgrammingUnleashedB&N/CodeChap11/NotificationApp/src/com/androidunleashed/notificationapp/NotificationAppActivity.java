package com.androidunleashed.notificationapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.app.Notification;
import android.widget.Button;
import android.view.View.OnClickListener;

public class NotificationAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_app);
        Button createButton = (Button) findViewById(R.id.createbutton);
        createButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), TargetActivity.class);
                PendingIntent pendIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, 0);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); 
                Notification notification = new Notification();
                Notification.Builder builder = new Notification.Builder(getBaseContext())
               .setSmallIcon(R.drawable.ic_launcher)
               .setAutoCancel(true)
               .setTicker("There is a new notification")
               .setWhen(System.currentTimeMillis())
               .setContentTitle("New E-mail")
               .setContentText("You have one unread message")
               .setContentIntent(pendIntent);   
                notification = builder.getNotification();
                notificationManager.notify(0, notification);
            }
        });
    }
}

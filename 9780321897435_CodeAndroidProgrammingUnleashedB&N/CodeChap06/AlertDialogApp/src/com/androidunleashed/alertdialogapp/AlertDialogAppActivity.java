package com.androidunleashed.alertdialogapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class AlertDialogAppActivity extends Activity implements OnClickListener   {
    TextView resp;
    
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_app);
        resp = (TextView)this.findViewById(R.id.response);
        Button b = (Button)this.findViewById(R.id.click_btn);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder  alertDialog = new AlertDialog.Builder(this);   
        alertDialog.setTitle("Alert window");   
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.setMessage("Enter your name ");   
        final EditText username = new EditText(this);
        alertDialog.setView(username);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {   
            public void onClick(DialogInterface dialog, int buttonId) {            
                String str = username.getText().toString();
                resp.setText("Welcome "+str+ "!");    
                return;   
            } 
        });    
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {   
            public void onClick(DialogInterface dialog, int buttonId) {   
                return;   
            } 
        });    
        alertDialog.show();   
    } 
}

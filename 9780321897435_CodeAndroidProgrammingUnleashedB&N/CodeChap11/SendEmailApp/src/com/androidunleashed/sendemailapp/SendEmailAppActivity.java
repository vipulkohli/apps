package com.androidunleashed.sendemailapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailAppActivity extends Activity {
    Button sendbutton;
    EditText toAddress, ccAddress, bccAddress, subject, emailMessage;
    String  toAdds, ccAdds, bccAdds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email_app);
        sendbutton=(Button) findViewById(R.id.send_button);
        toAddress=(EditText) findViewById(R.id.toaddresses);
        ccAddress=(EditText) findViewById(R.id.ccaddresses);
        bccAddress=(EditText) findViewById(R.id.bccaddresses);
        subject=(EditText) findViewById(R.id.emailsubject);
        emailMessage=(EditText) findViewById(R.id.emailtext);
        sendbutton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(toAddress.getText().length() >0) {
                    toAdds = '"'+toAddress.getText().toString()+'"';
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ toAdds});
                }
                if(ccAddress.getText().length() >0) {
                    ccAdds = '"'+ccAddress.getText().toString()+'"';
                    emailIntent.putExtra(Intent.EXTRA_CC, new String[]{ ccAdds});
                }
                if(bccAddress.getText().length() >0) {
                    bccAdds = '"'+bccAddress.getText().toString()+'"';
                    emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{ bccAdds});
                }
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailMessage.getText());
                emailIntent.setType("plain/text");
                startActivity(Intent.createChooser(emailIntent, "Sending Email"));
            }
        });
    }
}

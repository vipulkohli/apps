package com.androidunleashed.helloworldapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.util.Log;

public class HelloWorldAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world_app);
        TextView mesg = (TextView)findViewById(R.id.message);   
        mesg.setText("Hello World!");    
        // Please don't worry about the below statements
        // They are discussed in Chapter 5, Using Selection Widgets and Debugging
 /*       int a,b,c;
        a=10;
        b=5;
        c=a*b;
        callExcep();
        Log.v("CheckValue1", "a = " + a);
        Log.v("CheckValue2", "b = " + b);
        Log.v("CheckValue3", "c = " + c);
        Log.i("InfoTag", "Program is working correctly up till here");
        Log.e("ErrorTag", "Error—Some error has occurred here"); 
      */  
    } 
    /*
    public void callExcep() {
        throw new RuntimeException("RuntimeException testing");
 }*/

}

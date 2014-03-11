package com.androidunleashed.dispimageapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.view.View; 
import android.view.View.OnClickListener;

public class DispImageAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_image_app);
        final ImageView image = (ImageView) findViewById(R.id.image_toview);   
        final ToggleButton changeButton=(ToggleButton)findViewById(R.id.change_image);    
        changeButton.setOnClickListener(new OnClickListener(){            
            public void onClick(View v){              
                if (changeButton.isChecked()) {
                    image.setImageResource(R.drawable.bintupic2);  
                }
                else {
                    image.setImageResource(R.drawable.bintupic);  
                }
            }
        });
    }
}

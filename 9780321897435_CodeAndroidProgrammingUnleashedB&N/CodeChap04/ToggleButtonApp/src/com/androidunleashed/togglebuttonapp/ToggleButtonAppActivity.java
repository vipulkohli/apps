package com.androidunleashed.togglebuttonapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;
import android.view.View;

public class ToggleButtonAppActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_app);
        final TextView resp = (TextView)this.findViewById(R.id.response);
        final ToggleButton playStopButton = (ToggleButton) findViewById(R.id.playstop_btn);
        playStopButton.setChecked(true);
        playStopButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (playStopButton.isChecked()) {
                	playStopButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.play)); 
                    resp.setText("Stop button is toggled to Play button");
                } 
                else {
                	playStopButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.stop));
                    resp.setText("Play button is toggled to Stop button");
                }
            }
        });
    }
}

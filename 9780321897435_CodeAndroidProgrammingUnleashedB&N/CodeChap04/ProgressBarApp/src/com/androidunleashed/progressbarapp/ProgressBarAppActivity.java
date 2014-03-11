package com.androidunleashed.progressbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ToggleButton;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.os.Handler;

public class ProgressBarAppActivity extends Activity {
    MediaPlayer mp;
    ProgressBar progressBar;
    private final Handler handler = new Handler();
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_app);
        final TextView response = (TextView)this.findViewById(R.id.response);
        response.setText("Select Play button to play audio");
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
      	//This application will work only when an mp3 song renamed to song1.mp3 is copied to res/raw folder
        mp = MediaPlayer.create(ProgressBarAppActivity.this,R.raw.song1);
        final ToggleButton playStopButton = (ToggleButton) 
        findViewById(R.id.playstop_btn); 
        progressBar.setProgress(0);
        progressBar.setMax(mp.getDuration());
        
        playStopButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (playStopButton.isChecked()) {
                    response.setText("Select Stop button to stop audio");   
                    playStopButton.setBackgroundDrawable(
                        getResources().getDrawable(R.drawable.stop));
                    mp.start(); 
                    updateProgressBar();
                } 
                else {
                    response.setText("Select Play button to play audio");
                    playStopButton.setBackgroundDrawable(
                        getResources().getDrawable(R.drawable.play));
                     mp.pause();
                 }
             }
        });
    }
  
    private void updateProgressBar() {
        progressBar.setProgress(mp.getCurrentPosition());
        if (mp.isPlaying()) {
            Runnable notification = new Runnable() {
                public void run() {
                    updateProgressBar();
                }
            };
            handler.postDelayed(notification,1000);
        }
    }
}

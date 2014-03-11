package com.androidunleashed.playaudioapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ToggleButton;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;

public class PlayAudioAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_audio_app);
        final TextView response = (TextView)this.findViewById(R.id.response);
        response.setText("Select Play button to play audio");
    	//This application will work only when an mp3 song renamed to song1.mp3 is copied to res/raw folder
        final MediaPlayer mp = MediaPlayer.create(PlayAudioAppActivity.this,R.raw.song1);
        final ToggleButton playStopButton = (ToggleButton) 
            findViewById(R.id.playstop_btn); 
        playStopButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 if (playStopButton.isChecked()) {
                     response.setText("Select Stop button to stop audio");
                     playStopButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.stop));
                       mp.start();     
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
}

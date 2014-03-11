package com.androidunleashed.playvideoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_app);
        Button playvideo_button=(Button)findViewById(R.id.playvideo);
        playvideo_button.setOnClickListener(new OnClickListener() {
            public void onClick(View view){
            	//This application will work only when a video file  renamed 
            	//to video.mp4 is loaded onto the SD card of the device/emulator
            	VideoView videovw=(VideoView)findViewById(R.id.video);
                videovw.setMediaController(new 
                    MediaController(PlayVideoAppActivity.this)); 
                videovw.setVideoPath("sdcard/video.mp4");
                videovw.requestFocus(); 
                videovw.start(); 
            }
        });
    }
}

package com.androidunleashed.frameanimapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ToggleButton;
import android.widget.ImageView;

public class FrameAnimAppActivity extends Activity {
    ImageView imgView;
    AnimationDrawable animation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim_app);
        final ToggleButton startStopButton = (ToggleButton) findViewById(R.id.startstop_button);
        imgView = (ImageView)findViewById(R.id.imgview);
        createAnimation() ;
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startStopButton.isChecked()) 
                    animation.start();
                else
                    animation.stop();
            }
        });
    }

    private void createAnimation(){
        animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.face1), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.face2), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.face3), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.face4), 100);
        animation.setOneShot(false);   
        imgView.setBackground(animation);
    }
}

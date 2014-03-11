package com.androidunleashed.tweenanimapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.widget.Button;
import android.view.animation.AnimationUtils;
import android.view.View;

public class TweenAnimAppActivity extends Activity {
    ImageView imgView;
    Animation animation; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim_app);
        Button alphaButton = (Button) findViewById(R.id.alpha_button);
        Button rotateButton = (Button) findViewById(R.id.rotate_button);
        Button scaleButton = (Button) findViewById(R.id.scale_button);
        Button translateButton = (Button) findViewById(R.id.translate_button);
        imgView = (ImageView)findViewById(R.id.imgview);
        alphaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(TweenAnimAppActivity.this, R.anim.alpha);
                imgView.startAnimation(animation); 
            }
        });
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               animation = AnimationUtils.loadAnimation(TweenAnimAppActivity.this, R.anim.rotate); 
               imgView.startAnimation(animation); 
            }
         });
         scaleButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 animation = AnimationUtils.loadAnimation(TweenAnimAppActivity.this, R.anim.scale);
                 imgView.startAnimation(animation); 
            }
        });
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               animation = AnimationUtils.loadAnimation(TweenAnimAppActivity.this, R.anim.translate);             
               imgView.startAnimation(animation); 
           }
       });
    }
}

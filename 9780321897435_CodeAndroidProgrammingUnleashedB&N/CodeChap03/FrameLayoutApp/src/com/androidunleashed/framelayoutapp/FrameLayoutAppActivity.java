package com.androidunleashed.framelayoutapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.view.View;

public class FrameLayoutAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_app);
        final ImageView first_image = (ImageView)this.findViewById(R.id.first_image);
        final ImageView second_image = (ImageView)this.findViewById(R.id.second_image);
        first_image.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                second_image.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);
            }
        });
        second_image.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                first_image.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);
            }
        });
    }
}

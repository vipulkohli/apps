package com.androidunleashed.googlemapapp;

import android.os.Bundle;
import com.google.android.maps.MapActivity;

public class GoogleMapAppActivity extends MapActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map_app);
    }

    protected boolean isRouteDisplayed() {
        return true;
    }
}

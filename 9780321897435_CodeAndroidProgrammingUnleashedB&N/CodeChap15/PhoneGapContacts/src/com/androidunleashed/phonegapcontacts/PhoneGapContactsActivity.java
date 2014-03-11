package com.androidunleashed.phonegapcontacts;

import android.os.Bundle;
import org.apache.cordova.DroidGap;

public class PhoneGapContactsActivity extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
}

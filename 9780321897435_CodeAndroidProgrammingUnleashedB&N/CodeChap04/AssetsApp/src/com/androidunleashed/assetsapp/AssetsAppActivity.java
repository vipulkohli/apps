package com.androidunleashed.assetsapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.InputStream;
import android.content.res.AssetManager;
import java.io.IOException;

public class AssetsAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_app);
        TextView fileView=(TextView)findViewById(R.id.file_view);
        InputStream input;  
        AssetManager assetManager = getAssets();  
        try {  
            input = assetManager.open("info.txt");  
            int fileSize = input.available();  
            byte[] buffer = new byte[fileSize];  
            input.read(buffer);  
            input.close();  
            String textForm = new String(buffer);  
            fileView.setText(textForm);  
        } catch (IOException e) {  
            fileView.setText("Some exception has occurred");  
        }  
    }
}

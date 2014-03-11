package com.androidunleashed.httpapp;

import android.app.Activity;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class HttpAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_app);
        final EditText urlAdd = (EditText) findViewById(R.id.url_add);
        Button goButton = (Button)this.findViewById(R.id.go_button);
        goButton.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                new AccessAsync().execute(urlAdd.getText().toString().trim());   
            } 
        });           
    }

    private InputStream openHttpConnection(String urlString) throws IOException {
        InputStream inStream = null;
        int checkConn = -1;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            checkConn = httpConn.getResponseCode();
            if (checkConn == HttpURLConnection.HTTP_OK) {
                inStream = httpConn.getInputStream();
            }
        }
        catch (Exception ex) {
            throw new IOException("Error connecting");
        }
        return inStream;
    }

    private Bitmap downloadImage(String urladdr) {
        Bitmap bmap = null;
        InputStream inStream = null;
        try {
            inStream = openHttpConnection(urladdr);
            bmap = BitmapFactory.decodeStream(inStream);
            inStream.close();
        } catch (IOException e1) {
            e1.printStackTrace();     
        }
        return bmap;
    }

    private class AccessAsync extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... urladds) {
           return downloadImage(urladds[0]);
       }
       protected void onPostExecute(Bitmap bmp) {
           ImageView img = (ImageView) findViewById(R.id.img);
           img.setImageBitmap(bmp);
       }
    }
}

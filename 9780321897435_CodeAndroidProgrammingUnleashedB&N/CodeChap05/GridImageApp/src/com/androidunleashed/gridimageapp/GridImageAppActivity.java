package com.androidunleashed.gridimageapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.view.View;
import android.widget.ImageView;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.ViewGroup;

public class GridImageAppActivity extends Activity implements 
    AdapterView.OnItemClickListener {
    TextView selectedOpt; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image_app);    
        selectedOpt=(TextView) findViewById(R.id.selectedopt); 
        GridView g=(GridView) findViewById(R.id.grid);    
        g.setAdapter(new ImageAdapter(this));  
        g.setOnItemClickListener(this);
    }
    
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        int p=position+1;
        selectedOpt.setText("You have selected the image number "+p);
    } 
    
    public class ImageAdapter extends BaseAdapter {
        private Context contxt;
        Integer[] images = {
            R.drawable.prod1,
            R.drawable.prod2,
            R.drawable.prod3,
            R.drawable.prod4,
            R.drawable.prod5
        };

        public ImageAdapter(Context c) {
            contxt = c;
        }

        public int getCount() {
            return images.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(contxt); 
            imageView.setImageResource(images[position]); 
            imageView.setLayoutParams(new GridView.LayoutParams(100, 120)); 
            return imageView; 
        }
    }
}

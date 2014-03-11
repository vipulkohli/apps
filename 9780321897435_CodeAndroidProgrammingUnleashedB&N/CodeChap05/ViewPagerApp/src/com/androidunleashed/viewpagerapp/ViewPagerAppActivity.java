package com.androidunleashed.viewpagerapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;

public class ViewPagerAppActivity extends Activity {
	 public TextView selectedOpt; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_app);
        selectedOpt=(TextView) findViewById(R.id.selectedopt); 
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ImageAdapter());  
        viewPager.setOnPageChangeListener(new PageListener()); 
    }

    public class ImageAdapter extends PagerAdapter {
        Integer[] images = {
            R.drawable.prod1,
            R.drawable.prod2,
            R.drawable.prod3,
            R.drawable.prod4,
            R.drawable.prod5
        };

        public Object instantiateItem(View container, int position) {  	
         	ImageView view = new ImageView(ViewPagerAppActivity.this);
			view.setImageResource(images[position]);
			((ViewPager) container).addView(view, 0);
			return view;
        	}
        
        @Override
        public int getCount() {
            return images.length;
        }

        
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
        }
        
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
        }
 }
    
    private class PageListener extends SimpleOnPageChangeListener{ 
        public void onPageSelected(int position) {       
           selectedOpt.setText("You have selected the page number "+position);
    } 
              
    }
}

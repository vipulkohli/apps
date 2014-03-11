package com.androidunleashed.knowlocationapp;

import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.GeoPoint;
import android.app.AlertDialog;
import android.graphics.Canvas;
import com.google.android.maps.OverlayItem;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import java.util.ArrayList;
import android.content.DialogInterface;

public class KnowLocationAppActivity extends MapActivity  {
    private MapController mapController;
    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_location_app);       
        mapView = (MapView) findViewById(R.id.mapvw);
        mapView.setBuiltInZoomControls(true);
        mapController = mapView.getController();        
        Drawable marker=getResources().getDrawable(R.drawable.spot);
        marker.setBounds(0, 0, marker.getIntrinsicWidth(),marker.getIntrinsicHeight());
        MyOverlay mapOverlay = new MyOverlay(marker);
        mapView.getOverlays().add(mapOverlay);
        GeoPoint SantaRosa = new GeoPoint((int)(38.4405556*1000000),(int)(-122.7133333*1000000));
        GeoPoint SanFrancisco = new GeoPoint((int)(37.775*1000000),(int)(-122.4183333*1000000));
        GeoPoint SanJose = new GeoPoint((int)(37.3394444*1000000),(int)(-121.8938889*1000000));
        mapOverlay.addPoint(SantaRosa,"Santa Rosa", "Santa Rosa");
        mapOverlay.addPoint(SanFrancisco ,"San Francisco", "San Francisco");
        mapOverlay.addPoint(SanJose ,"San Jose", "San Jose");
        GeoPoint point = mapOverlay.getCenter(); 
        mapView.getController().setCenter(point);
        mapController.setZoom(8);        
    }  

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

    class MyOverlay extends ItemizedOverlay<OverlayItem> {
        private ArrayList<OverlayItem> overlayItemList = new ArrayList<OverlayItem>();
        public MyOverlay(Drawable marker) {
            super(boundCenterBottom(marker));
            populate();
        }

        @Override
        protected boolean onTap(int index) {
            AlertDialog.Builder  alertDialog = new   AlertDialog.Builder(KnowLocationAppActivity.this);   
            alertDialog.setTitle("Alert window");   
            alertDialog.setMessage("The selected place is "+  overlayItemList.get(index).getTitle());   
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {   
                public void onClick(DialogInterface dialog, int buttonId) {   
                    return;   
                } 
            });    
            alertDialog.setIcon(R.drawable.ic_launcher);
            alertDialog.show();   
            return true;
        }

        public void addPoint(GeoPoint p, String title, String snippet){
            OverlayItem newItem = new OverlayItem(p, title, snippet);
            overlayItemList.add(newItem);
            populate();
        }

        @Override
        public void draw(Canvas canvas, MapView mapView, boolean shadow) {
            super.draw(canvas, mapView, shadow);
        }

        @Override
        protected OverlayItem createItem(int i) {
            return overlayItemList.get(i);
        }

        @Override
        public int size() {
            return overlayItemList.size();
        }
    }
}

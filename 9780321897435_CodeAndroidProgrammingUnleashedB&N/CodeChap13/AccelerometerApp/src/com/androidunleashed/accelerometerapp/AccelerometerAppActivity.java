package com.androidunleashed.accelerometerapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerAppActivity extends Activity implements SensorEventListener {

	TextView xAxisView,yAxisView, zAxisView;
     SensorManager sensorManager;
   
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_app);
        xAxisView=(TextView)findViewById(R.id.xaxisview);
        yAxisView=(TextView)findViewById(R.id.yaxisview);
        zAxisView=(TextView)findViewById(R.id.zaxisview); 
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);       
    }
    
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }

    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
        	float x=event.values[0];
			float y=event.values[1];
			float z=event.values[2];
			xAxisView.setText("X: "+x);
			yAxisView.setText("Y: "+y);
			zAxisView.setText("Z: "+z);
        }    
    } 
}

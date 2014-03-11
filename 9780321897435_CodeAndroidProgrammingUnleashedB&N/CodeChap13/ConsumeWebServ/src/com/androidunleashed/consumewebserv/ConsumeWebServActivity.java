package com.androidunleashed.consumewebserv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.PropertyInfo;

public class ConsumeWebServActivity extends Activity {
    private static final String NAMESPACE = "http://tempuri.org/"; 
    private static final String METHOD_NAME = "CelsiusToFahrenheit";
    private static final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
    private static final String SOAP_ACTION = "http://tempuri.org/CelsiusToFahrenheit";
    private TextView fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consume_web_serv);
        final EditText celsiusVal = (EditText) findViewById(R.id.celsius_value);
        Button submitButton = (Button)this.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v) {
                fahrenheit = (TextView) findViewById(R.id.fahrenheit); 
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 
                PropertyInfo celsiusProp = new PropertyInfo();
                celsiusProp.setName("Celsius");
                celsiusProp.setValue(Integer.parseInt(celsiusVal.getText().toString()));
                celsiusProp.setType(double.class);
                request.addProperty(celsiusProp); 
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.debug=true;
                try {
                    androidHttpTransport.call(SOAP_ACTION, envelope);
                    SoapPrimitive resultString = (SoapPrimitive) envelope.getResponse();
                    fahrenheit.setText("Value in Farenheit is " + resultString.toString());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } 
        });
    }
}

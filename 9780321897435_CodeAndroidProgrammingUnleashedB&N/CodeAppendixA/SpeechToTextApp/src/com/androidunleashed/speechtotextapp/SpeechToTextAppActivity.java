package com.androidunleashed.speechtotextapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.content.pm.PackageManager;
import java.util.List;
import android.speech.RecognizerIntent;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.view.View;
import java.util.Locale;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class SpeechToTextAppActivity extends Activity {
    private static final int VOICE_RECOGNITION_REQUEST = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text_app);
        Button speakButton = (Button) findViewById(R.id.speak_button);  
        PackageManager pm = getPackageManager();        
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);       
        if (activities.size() == 0){           
            speakButton.setEnabled(false);        
            speakButton.setText("Recognizer not present");       
        }   
        else { 
            speakButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {   
                    startRecognize(); 
                }  
            }); 
        }
    }

    public void startRecognize() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please speak slowly");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ListView textList = (ListView) findViewById(R.id.list_view);    
        if (requestCode == VOICE_RECOGNITION_REQUEST && resultCode == RESULT_OK) {
            ArrayList<String> resultingText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            float[] confidence;
            String confidenceExtra = RecognizerIntent.EXTRA_CONFIDENCE_SCORES;
            confidence = data.getFloatArrayExtra(confidenceExtra);
            if(confidence[0] >= 0.5)
                textList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  resultingText));   
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

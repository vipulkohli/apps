package com.androidunleashed.preferencefragapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.TextView;

public class PreferenceFragAppActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_preference_frag_app);
         startActivity(new Intent(this, PrefActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
        TextView pizza=(TextView)findViewById(R.id.pizza);
        TextView name=(TextView)findViewById(R.id.name);
        TextView ringtone=(TextView)findViewById(R.id.ringtone);
        TextView fruit=(TextView)findViewById(R.id.fruit);
        if (Boolean.valueOf(prefs.getBoolean("Pizzakey", false)))
            pizza.setText("You have selected Pizza");
        else
            pizza.setText("");
        ringtone.setText("The ringtone selected is "+prefs.getString("Audio", "Silent"));
        name.setText("The name entered is "+prefs.getString("Namekey",""));
        String selectedFruit = prefs.getString("fruits_list", "Apple"); 
        fruit.setText(selectedFruit);
    }
}

package com.example.tp_dev_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SayHi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        // receive intent from other activity -----------------------------------------------------------------------
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            TextView edit = findViewById(R.id.text_bonjour);
            edit.setText(value);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CycleDeVie", "onStart de say Hi");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CycleDeVie", "onResume de say Hi");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CycleDeVie", "onPause de say Hi");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CycleDeVie", "onStop de say Hi");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CycleDeVie", "onDestroy de say Hi");
    }
}

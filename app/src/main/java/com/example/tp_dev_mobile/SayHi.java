package com.example.tp_dev_mobile;

import android.app.Activity;
import android.os.Bundle;

public class SayHi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("key");
        }
    }
}

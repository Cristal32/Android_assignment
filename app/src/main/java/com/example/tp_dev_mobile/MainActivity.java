package com.example.tp_dev_mobile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button connect = findViewById(R.id.button_connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mylist.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CycleDeVie", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CycleDeVie", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CycleDeVie", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CycleDeVie", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CycleDeVie", "onDestroy");
    }

}
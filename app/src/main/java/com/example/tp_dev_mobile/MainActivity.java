package com.example.tp_dev_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("CycleDeVie", "onCreate");

        // text Nouveau compte listener
        TextView Text = (TextView) this.findViewById(R.id.text_newAccount);
        Text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myClick(v);
            }
        });

        // button connecter text listener
        Button button_connect = (Button) this.findViewById(R.id.button_connect);
        button_connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myClick(v);
            }
        });

        // toggle text listener
        ToggleButton toggle = (ToggleButton) this.findViewById(R.id.toggle);
        toggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myClick(v);
            }
        });
    }
    public void myClick(View v) {
        if (v.getId() == R.id.text_newAccount) {
            // Afficher un Toast
            Toast.makeText(this, "OK, vous voulez creer un nouveau compte", Toast.LENGTH_SHORT).show();
            return;
        }
        if (v.getId() == R.id.button_connect) {
            Toast.makeText(this, "OK, vous voulez vous connecter", Toast.LENGTH_SHORT).show();
            return;
        }
        if (v.getId() == R.id.toggle) {
            boolean isChecked = ((ToggleButton) v).isChecked();
            Toast.makeText(this, "OK, vous voulez switcher vers " + (isChecked ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
        }
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
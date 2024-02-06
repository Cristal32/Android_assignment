package com.example.tp_dev_mobile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    // Initialiser activityResultLauncher
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2000) {
                        if(result.getData() != null){
                            TextView edit = findViewById(R.id.text_newAccount);
                            edit.setText("" + result.getData().getStringExtra("Val"));
                        }
                    }
                }
            });
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

        // toggle text listener -------------------------------------------------
        ToggleButton toggle = (ToggleButton) this.findViewById(R.id.toggle);
        toggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myClick(v);
            }
        });

        // receive intent Val -----------------------------------------------------------------------
        if(this.getIntent().getExtras() != null){
            String s = this.getIntent().getExtras().getString("Val");
            TextView edit = findViewById(R.id.text_newAccount);
            edit.setText(s);
        }

        // receive intent Val -----------------------------------------------------------------------
        if(this.getIntent().getExtras() != null){
            String s = this.getIntent().getExtras().getString("madonnee");
            TextView edit = findViewById(R.id.text_newAccount);
            edit.setText(s);
        }

        // Create intent Val -----------------------------------------------------------------------
        Intent data = new Intent();
        data.putExtra("Val", "Bonjour");
        this.setResult(2000, data);


        // button connecter text listener ----------------------------------------
        Button button_connect = (Button) this.findViewById(R.id.button_connect);
        button_connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myClick(v);
            }
        });

    }
//    ===============================================================================
//    public void myClick(View v) {
//        if (v.getId() == R.id.text_newAccount) {
//            // Afficher un Toast
//            Toast.makeText(this, "OK, vous voulez creer un nouveau compte", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (v.getId() == R.id.button_connect) {
//            Toast.makeText(this, "OK, vous voulez vous connecter", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (v.getId() == R.id.toggle) {
//            boolean isChecked = ((ToggleButton) v).isChecked();
//            Toast.makeText(this, "OK, vous voulez switcher vers " + (isChecked ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
//        }
//    }

    public void myClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // text_newAccount --------------------------------------------------------------------
        if (v.getId() == R.id.text_newAccount) {

            // Dialog for "Nouveau compte" TextView
//            builder.setMessage("OK, vous voulez créer un nouveau compte")
//                    .setTitle("Nouveau compte");
            // Create intent to other activity -----------------------------------------------------------------------
            String value="Hello world";
            Intent i = new Intent(MainActivity.this, SayHi.class);
            i.putExtra("key",value);
            startActivity(i);

        //  button_connect --------------------------------------------------------------------
        } else if (v.getId() == R.id.button_connect) {

            // Dialog for "button_connect" Button
            // builder.setMessage("OK, vous voulez vous connecter")
            //        .setTitle("Connection");

            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("madonnee", "Hello");
            // startActivity(intent);
            activityResultLauncher.launch(intent);

        //  toggle --------------------------------------------------------------------
        } else if (v.getId() == R.id.toggle) {

            // Dialog for "toggle" ToggleButton
            boolean isChecked = ((ToggleButton) v).isChecked();
            builder.setMessage("OK, vous voulez switcher vers " + (isChecked ? "ON" : "OFF"))
                    .setTitle("Toggle State");

        }

        builder.setPositiveButton("OK", null); // You can add a listener for the "OK" button if needed

        // Create and show the AlertDialog --------------------------------------
        AlertDialog dialog = builder.create();
        dialog.show();
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
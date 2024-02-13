package com.example.tp_dev_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Mylist extends AppCompatActivity {

    private final ArrayList Etablissements = new ArrayList<>(Arrays.asList(
            new Etablissement("ENSIAS", "Ecole Nationale Supérieure d'Informatique et d'Analyse des Systémes", R.drawable.Ensias_logo)
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // get the reference of RecyclerView
        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        // set a LinearLayoutManager with default vertical orientation
        rv.setLayoutManager(new LinearLayoutManager(this));
        // call the constructor of MyAdapter to send the reference and data to Adapter
        rv.setAdapter(new MyAdapter(this, Etablissements));
    }

}

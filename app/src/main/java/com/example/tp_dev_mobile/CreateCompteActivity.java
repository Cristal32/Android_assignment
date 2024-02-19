package com.example.tp_dev_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.tp_dev_mobile.db.MyDatabase;
import com.example.tp_dev_mobile.db.User;

import java.util.List;

public class CreateCompteActivity extends AppCompatActivity {

    private Button create_btn;
    private EditText login;
    private EditText pwd;
    private TextView text;

    public static User user = new User();
    public static MyDatabase mydatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_compte);

        create_btn = findViewById(R.id.create);
        login = findViewById(R.id.login);
        pwd = findViewById(R.id.password);
        text = findViewById(R.id.haveAccount);

        mydatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "user_bd")
                .allowMainThreadQueries().build();


        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick(v);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick(v);
            }
        });
    }


    private void myClick(View v) {
        user.login = login.getText().toString();
        user.pwd = pwd.getText().toString();
        if (!(login.getText().toString()).isEmpty()) {
            List<User> usr = mydatabase.mydao().getUser(login.getText().toString());
            if (v.getId() == R.id.haveAccount) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else if (v.getId() == R.id.create) {
                if (usr.size() != 0) {
                    // Le compte existe déjà
                    Toast.makeText(getApplicationContext(), "Ce compte existe déjà", Toast.LENGTH_SHORT).show();
                } else {
                    // Ajouter le nouvel utilisateur à la base de données
                    mydatabase.mydao().addUser(user);
                    Toast.makeText(getApplicationContext(), "Le compte a été créé avec succès", Toast.LENGTH_SHORT).show();
                    // Rediriger vers l'écran de connexion (MainActivity)
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Veuillez entrer un login", Toast.LENGTH_SHORT).show();
        }
    }

}

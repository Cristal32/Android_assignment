package com.example.tp_dev_mobile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tp_dev_mobile.db.MyDatabase;
import com.example.tp_dev_mobile.db.MyDatabaseMigration;
import com.example.tp_dev_mobile.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button connect;
    private EditText login;
    private EditText pwd;
    private TextView text;

    public static User user = new User();
    public static MyDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connect = findViewById(R.id.button_connect);
        login = findViewById(R.id.login_input);
        pwd = findViewById(R.id.password_input);
        text = findViewById(R.id.text_newAccount);

        mydatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "user_bd")
                .addMigrations(new MyDatabaseMigration(1, 2))
                .allowMainThreadQueries().build();

        connect.setOnClickListener(new View.OnClickListener() {
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
        if (v.getId() == R.id.text_newAccount) {
            Intent intent = new Intent(this, CreateCompteActivity.class);
            startActivity(intent);
        }  else if (v.getId() == R.id.button_connect) {
            user.login = login.getText().toString();
            user.pwd = pwd.getText().toString();
            if (!(login.getText().toString()).matches("")) {
                List<User> usr = mydatabase.mydao().getUser(login.getText().toString());

                if (usr.size() != 0) {
                    if (usr.get(0).pwd.contentEquals(pwd.getText().toString())) {
                        Intent intent = new Intent(this, MyListActivity.class);
                        intent.putExtra("username",usr.get(0).getLogin());
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Mot de passe incorrect",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Compte non existant",
                            Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
}
package com.example.tp_dev_mobile.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @NonNull
    public String login;

    @ColumnInfo(name = "user_pwd")
    public String pwd;

    @NonNull
    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    public void setPwd(String pass) {
        this.pwd = pass;
    }
}

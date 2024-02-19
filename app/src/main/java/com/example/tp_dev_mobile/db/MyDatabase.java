package com.example.tp_dev_mobile.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Etablissement.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {
    public abstract User_dao mydao();

    public abstract Etablissement_dao etablissementDao();
}

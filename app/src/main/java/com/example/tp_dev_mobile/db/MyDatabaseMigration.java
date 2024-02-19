package com.example.tp_dev_mobile.db;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class MyDatabaseMigration extends Migration {
    public MyDatabaseMigration(int startVersion, int endVersion) {
        super(startVersion, endVersion);
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
        // Rename the column using SQL ALTER TABLE statement
        database.execSQL("ALTER TABLE users RENAME COLUMN user_pass TO user_pwd");
    }
}

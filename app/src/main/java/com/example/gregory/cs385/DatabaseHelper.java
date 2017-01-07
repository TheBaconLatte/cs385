package com.example.gregory.cs385;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gregory on 06/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";

    public static final String TABLE_NAME = "questions";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "QUESTION";
    public static final String COL_3 = "CHOICE_1";
    public static final String COL_4 = "CHOICE_2";
    public static final String COL_5 = "CHOICE_3";
    public static final String COL_6 = "CORRECT_CHOICE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, CHOICE_1 TEXT, CHOICE_2 TEXT, CHOICE_3 TEXT, CORRECT_CHOICE TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}

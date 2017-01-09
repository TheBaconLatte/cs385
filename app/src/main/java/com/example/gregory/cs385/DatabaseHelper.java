package com.example.gregory.cs385;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gregory on 06/01/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";

    public static final String TABLE_NAME = "questions";

    public static final String QUESTION_COL = "QUESTION";
    public static final String CHOICE_1_COL = "CHOICE_1";
    public static final String CHOICE_2_COL = "CHOICE_2";
    public static final String CHOICE_3_COL = "CHOICE_3";
    public static final String CORRECT_CHOICE_COL = "CORRECT_CHOICE";

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

    public boolean insertData(String question, String choice_1, String choice_2, String choice_3, String correct_choice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUESTION_COL, question);
        contentValues.put(CHOICE_1_COL, choice_1);
        contentValues.put(CHOICE_2_COL, choice_2);
        contentValues.put(CHOICE_3_COL, choice_3);
        contentValues.put(CORRECT_CHOICE_COL, correct_choice);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}


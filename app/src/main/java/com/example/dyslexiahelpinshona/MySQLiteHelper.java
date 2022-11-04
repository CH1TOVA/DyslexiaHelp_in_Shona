package com.example.dyslexiahelpinshona;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_HIGHSCORES = "highscores";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ALPHABET = "alphabet";
    public static final String COLUMN_NUMBERS = "numbers";
    public static final String COLUMN_VERBS = "verbs";
    public static final String COLUMN_ANIMALS = "animals";
    public static final String COLUMN_PROFESSIONS = "professions";
    public static final String COLUMN_COLORS = "colors";
    public static final String COLUMN_RELATIONS = "relations";

    private static final String DATABASE_NAME = "highscores.db";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
            "create table " + TABLE_HIGHSCORES
                    + "( "
                    + COLUMN_ID + " integer primary key autoincrement,"
                    + COLUMN_ALPHABET + " integer,"
                    + COLUMN_NUMBERS + " integer,"
                    + COLUMN_ANIMALS + " integer,"
                    + COLUMN_VERBS + " integer,"
                    + COLUMN_PROFESSIONS + " integer,"
                    + COLUMN_COLORS + " integer,"
                    + COLUMN_RELATIONS + " integer"
                    + ");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_ALPHABET,0);
            cv.put(COLUMN_NUMBERS,0);
            cv.put(COLUMN_ANIMALS,0);
            cv.put(COLUMN_VERBS,0);
            cv.put(COLUMN_PROFESSIONS,0);
            cv.put(COLUMN_COLORS,0);
            cv.put(COLUMN_RELATIONS,0);

            db.insert(TABLE_HIGHSCORES,null,cv);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES);
            onCreate(db);
        }
    }



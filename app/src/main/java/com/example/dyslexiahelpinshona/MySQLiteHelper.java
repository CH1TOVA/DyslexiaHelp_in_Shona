package com.example.dyslexiahelpinshona;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_HIGHSCORES = "highscores";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ALPHABET = "alphabet";
    public static final String COLUMN_VOWELS = "vowels";
    public static final String COLUMN_CONSONANTS = "consonants";
    public static final String COLUMN_VERB = "verbs";
    public static final String COLUMN_NOUN = "nouns";
    public static final String COLUMN_ADJECTIVE = "adjectives";
    public static final String COLUMN_PRONOUN = "pronouns";

    private static final String DATABASE_NAME = "highscores.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table " + TABLE_HIGHSCORES
                    + "( "
                    + COLUMN_ID + " integer primary key autoincrement,"
                    + COLUMN_ALPHABET + " integer,"
                    + COLUMN_VOWELS + " integer,"
                    + COLUMN_CONSONANTS + " integer,"
                    + COLUMN_VERB + " integer,"
                    + COLUMN_NOUN + " integer,"
                    + COLUMN_ADJECTIVE + " integer,"
                    + COLUMN_PRONOUN + " integer"
                    + ");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ALPHABET,0);
        cv.put(COLUMN_VOWELS,0);
        cv.put(COLUMN_CONSONANTS,0);
        cv.put(COLUMN_VERB,0);
        cv.put(COLUMN_NOUN,0);
        cv.put(COLUMN_ADJECTIVE,0);
        cv.put(COLUMN_PRONOUN,0);

        db.insert(TABLE_HIGHSCORES,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES);
        onCreate(db);
    }
}

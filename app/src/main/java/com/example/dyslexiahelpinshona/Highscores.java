package com.example.dyslexiahelpinshona;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Highscores {

    private static SQLiteDatabase database;
    private static MySQLiteHelper dbHelper;
    private static final String[] all_columns = {
            MySQLiteHelper.COLUMN_ALPHABET,
            MySQLiteHelper.COLUMN_NUMBERS,
            MySQLiteHelper.COLUMN_VERBS,
            MySQLiteHelper.COLUMN_ANIMALS,
            MySQLiteHelper.COLUMN_PROFESSIONS,
            MySQLiteHelper.COLUMN_COLORS,
            MySQLiteHelper.COLUMN_RELATIONS
    };

    public static void open(Context context) throws SQLException {
        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public static void close() {
        dbHelper.close();
    }

    public static List<Integer> getAllHighscores() {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_HIGHSCORES, all_columns, null, null, null, null, null);
        cursor.moveToFirst();
        List<Integer> highscores = new ArrayList<>();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            highscores.add(cursor.getInt(i));
        }
        cursor.close();
        return highscores;
    }

    public static int getHighscore(String column) {
        String[] col = {column};
        Cursor cursor = database.query(MySQLiteHelper.TABLE_HIGHSCORES, col, null, null, null, null, null);
        cursor.moveToFirst();
        int result = cursor.getInt(0);
        cursor.close();
        return result;
    }

    public static boolean setHighscore(String column, int newScore) {
        boolean result = false;
        String[] col = {column};
        Cursor cursor = database.query(MySQLiteHelper.TABLE_HIGHSCORES, col, null, null, null, null, null);
        cursor.moveToFirst();
        int oldScore = cursor.getInt(0);
        if (newScore > oldScore) {
            ContentValues cv = new ContentValues();
            cv.put(column, newScore);
            database.update(MySQLiteHelper.TABLE_HIGHSCORES, cv, MySQLiteHelper.COLUMN_ID + "=1", null);
            result = true;
        }
        cursor.close();
        return result;
    }
}

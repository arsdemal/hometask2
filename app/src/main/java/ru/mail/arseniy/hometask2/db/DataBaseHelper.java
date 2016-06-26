package ru.mail.arseniy.hometask2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import ru.mail.arseniy.hometask2.Tech;


public class  DataBaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "evol";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table technology (" +
                "id integer primary key autoincrement," +
                "picture text," +
                "title text," +
                "info text )";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllData(SQLiteDatabase db) {
        return db.query("technology", null, null, null, null, null, null);
    }

    public void insertTech(SQLiteDatabase db, List<Tech> teches) {
        Log.i("TAG", "Insert db");
        for ( Tech tech: teches) {
            ContentValues cv = new ContentValues();
            cv.put("picture",tech.picture);
            cv.put("title",tech.title);
            cv.put("info",tech.info);
            db.insert("technology",null,cv);
        }
    }

    public void deleteTech() {
        Log.i("TAG","Delete db");
    }
}

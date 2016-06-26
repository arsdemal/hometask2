package ru.mail.arseniy.hometask2.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ru.mail.arseniy.hometask2.MainApplication;
import ru.mail.arseniy.hometask2.db.DataBaseHelper;


public class ScreenSlideActivity extends AppCompatActivity{

    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        }

        db = MainApplication.getDBHelper().getReadableDatabase();
        cursor = MainApplication.getDBHelper().getAllData(db);

    }
}

package ru.mail.arseniy.hometask2.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import ru.mail.arseniy.hometask2.MainApplication;
import ru.mail.arseniy.hometask2.R;
import ru.mail.arseniy.hometask2.adapter.TechCursorAdapter;
import ru.mail.arseniy.hometask2.db.DataBaseHelper;


public class ScreenSlideActivity extends AppCompatActivity{

    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        db = MainApplication.getDBHelper().getReadableDatabase();
        cursor = MainApplication.getDBHelper().getAllData(db);
        Log.i("TAG", "Cursor(0) = " + cursor.getColumnName(0));
        ListView listView = (ListView) findViewById(R.id.list_view);
        TechCursorAdapter adapter = new TechCursorAdapter(this, cursor);
        listView.setAdapter(adapter);


    }
}

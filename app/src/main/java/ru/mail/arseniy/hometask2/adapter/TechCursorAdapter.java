package ru.mail.arseniy.hometask2.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;

import java.util.ArrayList;

import ru.mail.arseniy.hometask2.R;
import ru.mail.arseniy.hometask2.Tech;

public class TechCursorAdapter extends CursorAdapter {

    public TechCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}

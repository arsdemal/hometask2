package ru.mail.arseniy.hometask2.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.mail.arseniy.hometask2.R;
import ru.mail.arseniy.hometask2.Tech;
import ru.mail.arseniy.hometask2.image.DownloadImage;

public class TechCursorAdapter extends CursorAdapter {

    DownloadImage downloadImage;
    private LayoutInflater inflater;

    static class ViewHolder {
        TextView title;
        ImageView picture;
    }

    public TechCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        downloadImage = new DownloadImage();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =   inflater.inflate(R.layout.tech_item, null);
        ViewHolder holder = new ViewHolder();
        holder.picture = (ImageView) view.findViewById(R.id.imageItem);
        holder.title = (TextView) view.findViewById(R.id.titleItem);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.title.setText(cursor.getString(3));
        String picSrc = cursor.getString(2);
        holder.picture.setImageBitmap(downloadImage.getBitmapFromURL(picSrc));
    }
}

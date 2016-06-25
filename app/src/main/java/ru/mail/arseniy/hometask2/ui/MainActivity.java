package ru.mail.arseniy.hometask2.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ru.mail.arseniy.hometask2.JsonParser;
import ru.mail.arseniy.hometask2.MainApplication;
import ru.mail.arseniy.hometask2.R;
import ru.mail.arseniy.hometask2.StreamData;
import ru.mail.arseniy.hometask2.Tech;
import ru.mail.arseniy.hometask2.db.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private static class LoadDataTask extends AsyncTask<Void,Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            DataBaseHelper dbHelper = MainApplication.getDBHelper();

            HttpURLConnection conn = null;
            try {
                URL url = new URL("http://mobevo.ext.terrhq.ru/shr/j/ru/technology.js");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                InputStream in = new BufferedInputStream(conn.getInputStream());
                String data = StreamData.readStream(in);
                in.close();

                List<Tech> items = JsonParser.parse(data);

                return true;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

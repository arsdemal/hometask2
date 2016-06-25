package ru.mail.arseniy.hometask2;

import android.app.Application;

import ru.mail.arseniy.hometask2.db.DataBaseHelper;

public class MainApplication extends Application {

    private static DataBaseHelper dpHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        dpHelper = new DataBaseHelper(this);
    }

    public static synchronized DataBaseHelper getDBHelper() {
        return dpHelper;
    }
}

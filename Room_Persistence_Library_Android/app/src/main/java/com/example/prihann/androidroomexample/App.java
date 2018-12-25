package com.example.prihann.androidroomexample;

import android.app.Application;

import com.example.prihann.androidroomexample.database.AppDatabase;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.getAppDatabaseInstance(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

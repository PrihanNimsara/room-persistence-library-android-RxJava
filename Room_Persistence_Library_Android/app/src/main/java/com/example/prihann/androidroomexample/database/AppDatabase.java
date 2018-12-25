package com.example.prihann.androidroomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.prihann.androidroomexample.dao.StudentDao;
import com.example.prihann.androidroomexample.model.Student;

@Database(entities = {Student.class}, version = 6,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabaseInstance;

    public abstract StudentDao studentDao();

    public static AppDatabase getAppDatabaseInstance(Context context) {
        if (appDatabaseInstance == null) {
            appDatabaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_db_name")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabaseInstance;
    }


    public static void destroyAppDatabaseInstance() {
        if (appDatabaseInstance != null) {
            appDatabaseInstance = null;
        }
    }
}
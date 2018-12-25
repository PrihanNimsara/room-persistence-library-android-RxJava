package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T object);

    @Insert
    void insertMultipleObject(T... objects);

    @Insert
    void insertMultipleListObject(List<T> objectList);

    @Delete
    void delete(T object);

    @Update
    void update(T object);
}

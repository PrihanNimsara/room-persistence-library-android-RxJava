package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;


@Dao
public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(T object);

//    @Insert
//    Single<Long> insertMultipleObject(T... objects);
//
//    @Insert
//    Single<Long> insertMultipleListObject(List<T> objectList);

    @Delete
    Single<Integer> delete(T object);

    @Update
    Single<Integer> update(T object);
}

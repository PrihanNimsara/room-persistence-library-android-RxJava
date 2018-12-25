package com.example.prihann.androidroomexample.repo;

import android.content.Context;


import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class StudentRepo implements Crud {

    private AppDatabase appDatabase;

    public StudentRepo(Context context) {
        this.appDatabase = AppDatabase.getAppDatabaseInstance(context);
    }

    @Override
    public Boolean create(Object item) {
        Completable completable = appDatabase.studentDao().insert((Student) item);
        completable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        return null;
    }

    @Override
    public Boolean update(Object item) {


        Single<Integer> single = appDatabase.studentDao().update((Student) item);
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        return null;
    }

    @Override
    public Boolean delete(Object item) {
        Single<Integer> single = appDatabase.studentDao().delete((Student) item);
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        return null;
    }

    @Override
    public List<?> findAll() {
        final List<Student> studentList1=null;
        Maybe<List<Student>> maybe = appDatabase.studentDao().getAllStudents();
        maybe.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<Student>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Student> studentList) {
                    studentList1.addAll(studentList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return studentList1;
    }
}

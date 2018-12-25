package com.example.prihann.androidroomexample.repo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;

import java.util.List;

public class StudentRepo implements Crud {

    private AppDatabase appDatabase;

    public StudentRepo(Context context) {
        this.appDatabase = AppDatabase.getAppDatabaseInstance(context);
    }

    @Override
    public Boolean create(Object item) {
        InsertStudentAsyncTask insertStudentAsyncTask = new InsertStudentAsyncTask((Student) item);
        insertStudentAsyncTask.execute();
        return null;
    }

    @Override
    public Boolean update(Object item) {
        UpdateStudentAsyncTask updateStudentAsyncTask = new UpdateStudentAsyncTask((Student) item);
        updateStudentAsyncTask.execute();
        return null;
    }

    @Override
    public Boolean delete(Object item) {
        DeleteStudentAsyncTask deleteStudentAsyncTask = new DeleteStudentAsyncTask((Student) item);
        deleteStudentAsyncTask.execute();
        return null;
    }

    @Override
    public List<?> findAll() {
        try {
            return new FindUsersAsyncTask().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private class InsertStudentAsyncTask extends AsyncTask<Void, Void, Void> {

        Student student;

        public InsertStudentAsyncTask(Student student) {
            this.student = student;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            appDatabase.studentDao().insert(student);
            return null;
        }
    }

    private class FindUsersAsyncTask extends AsyncTask<Void, Void, List<Student>> {
        public FindUsersAsyncTask() {
        }

        @Override
        protected List<Student> doInBackground(Void... voids) {
            return appDatabase.studentDao().getAllStudents();
        }
    }

    private class UpdateStudentAsyncTask extends AsyncTask<Void, Void, Void> {
        private Student student;

        public UpdateStudentAsyncTask(Student student) {
            this.student = student;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            appDatabase.studentDao().update(student);
            return null;
        }
    }

    private class DeleteStudentAsyncTask extends AsyncTask<Void, Void, Void> {
        Student student;

        public DeleteStudentAsyncTask(Student student) {
            this.student = student;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            appDatabase.studentDao().delete(student);
            return null;
        }
    }
}

package com.example.prihann.androidroomexample.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.prihann.androidroomexample.R;
import com.example.prihann.androidroomexample.model.Student;
import com.example.prihann.androidroomexample.repo.StudentRepo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Context  context = getApplicationContext();

//        StudentRepo studentRepo = new StudentRepo(context);
//        Student student = new Student();
//        student.setStudentId("me123");
//        student.setStudentName("prian");
//        student.setStudentAge(22);
//        student.setStudentCountry("LK");
//        studentRepo.create(student);
    }


}

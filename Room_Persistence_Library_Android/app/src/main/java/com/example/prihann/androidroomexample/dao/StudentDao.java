package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.example.prihann.androidroomexample.model.Student;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;


@Dao
public interface StudentDao extends BaseDao<Student>{
    @Query("SELECT * FROM student")
    Maybe<List<Student>> getAllStudents();

    @Query("SELECT * FROM student where student_id LIKE  :studentId")
    Maybe<Student> findStudentByUsingStudentId(String studentId);

    @Query("SELECT COUNT(*) from student")
    Maybe<Integer> countStudents();
}

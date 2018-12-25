package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.example.prihann.androidroomexample.model.Student;
import java.util.List;

@Dao
public interface StudentDao extends BaseDao<Student>{
    @Query("SELECT * FROM student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM student where student_id LIKE  :studentId")
    Student findStudentByUsingStudentId(String studentId);

    @Query("SELECT COUNT(*) from student")
    int countStudents();
}

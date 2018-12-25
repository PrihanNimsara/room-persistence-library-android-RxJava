package com.example.prihann.androidroomexample.repo;

import java.util.List;

public interface Crud {
    Boolean create(Object item);
    Boolean update(Object item);
    Boolean delete(Object item);
    List<?> findAll();
}

package com.example.kyra.repository;

import com.example.kyra.entity.Student;

import java.util.Map;

public interface StudentRepository {
    Student getByKey(Integer key);
    void create(Integer key,Student student);
    Map<Integer,Student> getAll();
    Student deleteById(Integer id);
}

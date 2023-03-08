package com.example.kyra.service;

import com.example.kyra.entity.Student;

import java.util.List;

public interface StudentService {
    Student getById(Integer id);
    void createStudent(String name, Integer age, String email);
    List<Student> getAll();
    List<Student> getAllSorted();

    List<Student> getAllSorted(String sort);  // overloading

    String updateStudentEmail(Integer id, String email);

    String deleteStudentById(Integer id);
}

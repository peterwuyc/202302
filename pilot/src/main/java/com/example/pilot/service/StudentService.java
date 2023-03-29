package com.example.pilot.service;

import com.example.pilot.entity.Student;
import com.example.pilot.entity.request.StudentRequestBody;

import java.util.List;

public interface StudentService {

    Student getById(Integer id);
    void createStudent(StudentRequestBody studentRequestBody);
    List<Student> getAll();
    List<Student> getAllSorted();
    List<Student> getAllSorted(String sort); //overloading

    String updateStudentEmail(Integer id,String email);
    String deleteStudentById(Integer id);

    Student getStudentByEmail(String email);

}

package com.example.pilot.service;

import com.example.pilot.entity.Student;
import com.example.pilot.entity.request.StudentRequestBody;
import com.example.pilot.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service //
public class StudentServiceImplement implements StudentService{

    @Autowired  // get repository instance from IOC container
    private StudentRepository repository;
    @Override
    public Student getById(Integer id) {
        Optional<Student> studentOptional= repository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else throw new RuntimeException("no such student");
    }

    @Override
    public void createStudent(StudentRequestBody studentRequestBody) {
        Student student=new Student();
        BeanUtils.copyProperties(studentRequestBody,student);
        student.setId((int)(Math.random()*1000));
        repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> getAllSorted() {
        return repository.findAllOrderByAgeAsc();
    }

    @Override
    public List<Student> getAllSorted(String sort) {

        //sort -> age or email
        List<Student> collect = repository.findAll()
                .stream()
                .sorted((s1, s2) -> {
                    if("age".equals(sort)){
                        return s1.getAge() - s2.getAge();
                    }else if("name".equals(sort)){
                        return s1.getName().compareTo(s2.getName());
                    }else return 0;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String updateStudentEmail(Integer id, String email) {
        Optional<Student> optionalStudent=repository.findById(id);
        if(optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            student.setEmail(email);
            repository.save(student);
        }
        return "success";
    }

    @Override
    public String deleteStudentById(Integer id) {
        repository.deleteById(id);
        return "success";
    }

    @Override
    public Student getStudentByEmail(String email) {
        return repository.getOneStudentByEmail(email);
    }

}

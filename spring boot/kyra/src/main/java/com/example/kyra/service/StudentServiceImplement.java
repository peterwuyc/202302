package com.example.kyra.service;

import com.example.kyra.entity.Student;
import com.example.kyra.repository.StudentRepository;
import com.example.kyra.repository.StudentRepositoryImplement;
import org.springframework.util.StringUtils;


import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImplement implements  StudentService{
    StudentRepository repository=new StudentRepositoryImplement();

    @Override
    public Student getById(Integer id) {
        return repository.getByKey(id);
    }

    @Override
    public void createStudent(String name, Integer age, String email) {
        Student student = new Student(name, age, email);
        repository.create((int) (Math.random() * 100), student);  // todo: why random *100?
        // previous
//        String[] strings=input.split(",");
//        Integer id=Integer.parseInt(strings[1]);
//        String name=strings[2];
//        Student student=new Student();
//        student.name=name;
//        repository.create(id,student);
    }

    @Override
    public List<Student> getAll() {
        Map<Integer,Student> map=repository.getAll();
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    // default using age
    @Override
    public List<Student> getAllSorted() {
        Map<Integer,Student> map= repository.getAll(); //reuse
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                //.sorted((s1,s2)->s1.getAge()-s2.getAge())
                .sorted(Comparator.comparingInt(Student::getAge))  // REM!
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllSorted(String sort) {
        Map<Integer, Student> map = repository.getAll();
        // input sort can be "age" or "email"

        /*
        // before java 8 implementation:

        List<Student> list = new LinkedList<>();
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if ("age".equals(sort)) {
                    return o1.getAge() - o2.getAge();
                } else if ("email".equals(sort)) {
                    return o1.getEmail().compareTo(o2.getEmail());
                } else {
                    return 0;
                    // or throw exception, can't compare
                }
            }
        });

        return list;
         */

        return map.entrySet()
                .stream()
                .map(e -> e.getValue()) // to student stream
                .sorted((o1, o2) -> {
                    if ("age".equals(sort)) {
                        return o1.getAge() - o2.getAge();
                    } else if ("email".equals(sort)) {
                        return o1.getEmail().compareTo(o2.getEmail());
                    } else if ("name".equals(sort)) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return 0;
                        // or throw exception, can't compare
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public String updateStudentEmail(Integer id, String email) {
        Student student = repository.getByKey(id);
        if (student == null)
//            throw new RuntimeException("no such student id: " + id);
            throw new RuntimeException(String.format("no such student id: %s", id));

        if (StringUtils.hasText(email)) {
            student.setEmail(email);
            return "success!";
        } else {
            return "failed";
        }
    }

    @Override
    public String deleteStudentById(Integer id) {
        Student student = repository.deleteById(id);
        if (student == null)
//            throw new RuntimeException("no such student id: " + id);
            throw new RuntimeException(String.format("no such student id: %s", id));
        else
            return "delete " + student.getEmail();
    }
}

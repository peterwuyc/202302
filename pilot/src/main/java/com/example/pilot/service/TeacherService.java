package com.example.pilot.service;

import com.example.pilot.entity.Student;
import com.example.pilot.entity.Teacher;
import com.example.pilot.repository.StudentRepository;
import com.example.pilot.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Teacher getById(Integer id){
        Optional<Teacher> teacherOptional= teacherRepository.findById(id);
        if(teacherOptional.isPresent()){
            return teacherOptional.get();
        }else throw new RuntimeException("no such teacher");
    }

    public void addStudent(Integer teacherId,Integer studentId){
        Optional<Teacher> teacherOptional= teacherRepository.findById(teacherId);
        if(teacherOptional.isPresent()){
            Teacher teacher= teacherOptional.get();
            Set<Student> students=teacher.getStudents();
            Optional<Student> studentOptional = studentRepository.findById(studentId);
            if(studentOptional.isPresent()){
                Student student=studentOptional.get();
                students.add(student);
            }
            teacherRepository.save(teacher);
        }else throw new RuntimeException("no such teacher");
    }
}

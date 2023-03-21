package com.example.pilot.controller;

import com.example.pilot.entity.Student;
import com.example.pilot.entity.request.StudentRequestBody;
import com.example.pilot.service.StudentService;
import com.example.pilot.service.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController // annotation
//metadata (information)
public class MyController {


    // Core feature of Spring framework->IOC inversion of control
//  ComponentScan -> scan Component
    // spring bean scope -> singleton prototype
   // -> dependency injection
    // java reflection->
    @Autowired
    private StudentService studentService; // 1 field

    @GetMapping("/v1/student")//map->
    public List<Student> getAllStudents(){

        List<Student> all = studentService.getAllSorted();
        return all;
    }

    @GetMapping("/v1/student/sort")
    public List<Student> getAllStudentsSorted(@RequestParam("sort")String sort){
        return studentService.getAllSorted(sort);
    }

    @PostMapping("/v1/student") // POST-> Create!!
    public String createOneStudent(@RequestBody StudentRequestBody studentRequestBody){
        studentService.createStudent(studentRequestBody);
        return "success!!!";
    }

    @PutMapping("/v1/student/{id}") // put->update
    public String updateStudentById(@PathVariable("id")Integer id,
                                    @RequestParam("email")String email){
        return studentService.updateStudentEmail(id,email);
    }

    @DeleteMapping("/v1/student/{id}")  //Delete
    public String deleteStudentById(@PathVariable("id")Integer id){
        return studentService.deleteStudentById(id);
    }



    @GetMapping("/v1/student/{id}")  // get by id
    public Student getById(@PathVariable("id")Integer id){
        return studentService.getById(id);
    }

    @GetMapping("/v1/student/email/{email}")  // get by id
    public Student getById(@PathVariable("email")String email){
        return studentService.getStudentByEmail(email);
    }

}

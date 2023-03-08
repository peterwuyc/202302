package com.example.kyra.controller;

import com.example.kyra.entity.Student;
import com.example.kyra.service.StudentService;
import com.example.kyra.service.StudentServiceImplement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    private StudentService studentService = new StudentServiceImplement();

    @GetMapping("/v1/student")
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    @GetMapping("/v1/student/sort")
    public List<Student> getAllStudentsSorted(@RequestParam("sort") String sort) {
        return studentService.getAllSorted();
    }

    @RequestMapping(value="/v2.index", method=RequestMethod.GET)   // CRUD
    public String getV2(){
        return "hello world v2";
    }

    // Creat (crud)
    @PostMapping("/v1/student")
    public String createOneStudent(@RequestParam("name") String name,
                                   @RequestParam("age") Integer age,
                                   @RequestParam("email") String email) {
        studentService.createStudent(name, age, email);
        return "success!";
    }

    // {} called placeholder
    // putmapping for updating
    @PutMapping("/v1/student/{id}")
    public String updateStudentById(@PathVariable("id") Integer id,
                                    @RequestParam("email") String email) {
        return studentService.updateStudentEmail(id, email);
    }

    @DeleteMapping("/v1/student/{id}")  // delete
    public String deleteStudentById(@PathVariable("id") Integer id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/v1/student/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

}

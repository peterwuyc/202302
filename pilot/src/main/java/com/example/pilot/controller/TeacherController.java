package com.example.pilot.controller;

import com.example.pilot.entity.Teacher;
import com.example.pilot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/v1/teacher/{id}")
    public Teacher getById(@PathVariable("id")Integer id){
        return teacherService.getById(id);
    }

    @PutMapping("/v1/teacher")
    public String addStudent(@RequestParam("teacherId")Integer teacherId,
                             @RequestParam("studentId")Integer studentId){
        teacherService.addStudent(teacherId,studentId);
        return "success";
    }
}

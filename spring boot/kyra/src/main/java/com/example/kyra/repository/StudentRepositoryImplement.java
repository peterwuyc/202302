package com.example.kyra.repository;

import com.example.kyra.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImplement implements StudentRepository{
    public static Map<Integer,Student> map=new HashMap<>();

    static {
        map.put(1,new Student("peter",20, "peter@gmail.com"));
        map.put(2,new Student("jack",24, "jack@gmail.com"));
        map.put(3,new Student("mike",18, "mike@gmail.com"));
    }

    public Student getByKey(Integer key){
        return map.get(key);// query select * from student g
    }

    public void create(Integer key,Student student){
        map.put(key,student);
    }

    @Override
    public Map<Integer, Student> getAll() {
        return map;
    }

    @Override
    public Student deleteById(Integer id) {
        return map.remove(id);
    }
}

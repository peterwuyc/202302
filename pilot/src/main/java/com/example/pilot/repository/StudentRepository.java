package com.example.pilot.repository;

import com.example.pilot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getOneStudentByEmail(@Param("email") String email); //reflection get + Students + By + Email

    @Query(value = "SELECT s FROM Student s order by s.age asc")
    List<Student> findAllOrderByAgeAsc();
}

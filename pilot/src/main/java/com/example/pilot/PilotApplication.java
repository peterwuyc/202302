package com.example.pilot;

import com.example.pilot.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
public class PilotApplication {

    public static void main(String[] args) {
        SpringApplication.run(PilotApplication.class, args);
        //com.mysql.cj.jdbc.ConnectionImpl@feb098f driver
    }

}

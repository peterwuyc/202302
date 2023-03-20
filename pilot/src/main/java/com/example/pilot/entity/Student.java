package com.example.pilot.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "student")
@Entity
public class Student{

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;  // encapsulation
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToMany(mappedBy = "students") // teacher entity manage set
    Set<Teacher> teacherSet=new HashSet<>();

    public Student(){

    }

    public Student(int id,String name, Integer age, String email) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
}

package com.example.pilot.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "teacher")
@Entity
public class Teacher {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String major;

    @ManyToMany(cascade = {CascadeType.ALL})
            @JoinTable(name = "teacher_student_map",
            joinColumns =@JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students=new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

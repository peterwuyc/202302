package com.example.pilot.entity;

import jakarta.persistence.*;

@Table(name = "card") // case sensitive
@Entity
public class Card {

    @Id
    @Column
    private Integer Id;

    @Column
    private Integer account;

    @Column
    private String imageUrl;

    @OneToOne(mappedBy = "card")
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

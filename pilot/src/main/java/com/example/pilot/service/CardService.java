package com.example.pilot.service;

import com.example.pilot.entity.Card;
import com.example.pilot.entity.Student;
import com.example.pilot.entity.request.CardRequestBody;
import com.example.pilot.repository.CardRepository;
import com.example.pilot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired // DI
    private StudentRepository studentRepository;
    @Autowired
    private CardRepository cardRepository;

    public void createCard(CardRequestBody cardRequestBody){
        Card card=new Card();
        card.setImageUrl(cardRequestBody.getImageUrl());
        card.setAccount(cardRequestBody.getAccount()!=null?cardRequestBody.getAccount():5);
        card.setId((int)(Math.random()*10000));

        Optional<Student> optionalStudent=
                studentRepository.findById(cardRequestBody.getStudentId());
        if (optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            card.setStudent(student);
            cardRepository.save(card);
        }else throw new RuntimeException("no such student in system!!");
    }

    public void add(Integer studentId,Integer num){
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            Card card=student.getCard();
            card.setAccount(card.getAccount()+num);
            //cardRepository.save(card);
        }else throw new RuntimeException("no such student in system!!");
    }
}

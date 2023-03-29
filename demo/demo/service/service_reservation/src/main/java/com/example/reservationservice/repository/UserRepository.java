package com.example.reservationservice.repository;

import com.example.reservationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Modifying
    @Transactional
    void deleteUserByUsername(String username);
    @Transactional
    User getUserByUsername(String username);

    @Transactional
    User getUserByUsernameAndFlightId(String username, String flightId);
}

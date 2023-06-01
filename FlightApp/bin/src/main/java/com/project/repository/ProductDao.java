package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}

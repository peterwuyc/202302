package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.MyOrder;
@Repository
public interface OrderDao extends JpaRepository<MyOrder, Integer>{


	public List<MyOrder> findAll();
	
}

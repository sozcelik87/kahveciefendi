package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType,Long>{

}

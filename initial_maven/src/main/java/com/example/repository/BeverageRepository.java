package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage,Long>{

}

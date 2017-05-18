package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Addition;

public interface AdditionRepository extends JpaRepository<Addition,Long>{

}

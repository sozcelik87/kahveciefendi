package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}

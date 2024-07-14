package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

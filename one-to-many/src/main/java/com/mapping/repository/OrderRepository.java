package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

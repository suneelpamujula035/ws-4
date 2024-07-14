package com.dailycodebuffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

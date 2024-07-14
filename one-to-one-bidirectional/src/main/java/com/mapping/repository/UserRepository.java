package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

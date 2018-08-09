package com.fpt.topgun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.topgun.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

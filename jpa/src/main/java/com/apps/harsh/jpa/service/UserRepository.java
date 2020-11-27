package com.apps.harsh.jpa.service;

import com.apps.harsh.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

}
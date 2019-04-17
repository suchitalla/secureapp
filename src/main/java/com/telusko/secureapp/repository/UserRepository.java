package com.telusko.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.telusko.secureapp.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);
}

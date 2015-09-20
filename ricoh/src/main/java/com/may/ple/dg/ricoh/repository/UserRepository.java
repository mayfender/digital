package com.may.ple.dg.ricoh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.may.ple.dg.ricoh.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUserName(String userName);
	List<User> findByStatus(int status);

}

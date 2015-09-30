package com.may.ple.dg.ricoh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.may.ple.dg.ricoh.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByUserName(String userName);
	List<Users> findByStatus(int status);

}

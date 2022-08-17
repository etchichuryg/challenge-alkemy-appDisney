package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository <User, Integer>{
	
    @Query(value = "SELECT * FROM app_disney.user where email=?;", nativeQuery = true)
	public User findUserByEmail(String email);

	
	public User getById(Integer id);


}

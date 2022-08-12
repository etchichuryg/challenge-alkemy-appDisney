package com.alkemy.challenge.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository <User, Integer>{
	Optional<User> findByEmail(String email);

/*	@Transactional
    @Modifying
    @Query("UPDATE AppUser a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);*/
}

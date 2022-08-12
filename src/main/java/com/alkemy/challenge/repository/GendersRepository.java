package com.alkemy.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Genders;

@Repository
public interface GendersRepository extends JpaRepository<Genders, Integer> {
	
	public Optional<Genders>findById(Integer id);
	public Genders getById (Integer genderId);
}

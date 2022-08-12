package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Characters;

@Repository
public interface CharactersRepository extends JpaRepository <Characters, Integer> {
	
	public Iterable<Object[]>findByName(String name);
	public Iterable<Object[]>findByAge(Integer age);
	@Query(value = "SELECT image, name from characters;" ,nativeQuery = true)
	public Iterable<Object[]>getAll();
	public List<Object[]>findByfilmsID(String movie);
}

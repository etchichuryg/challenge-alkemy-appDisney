package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Characters;

@Repository
public interface CharacterRepository extends JpaRepository <Characters, Integer> {
	
	@Query(value = "SELECT * FROM app_disney.characters WHERE name=?" ,nativeQuery = true)
	public Characters findByName(String name);
	
	@Query(value="SELECT * FROM app_disney.characters WHERE age=?", nativeQuery = true)
	public Characters findByAge(Integer age);
	
	@Query(value = "SELECT image, name from app_disney.characters;" ,nativeQuery = true)
	public List<Characters>getAll();
	
	@Query(value="SELECT * FROM app_disney.characters WHERE id_movie=?;", nativeQuery = true)
	public List<Characters>findByMovies(Integer id);
	
	
}

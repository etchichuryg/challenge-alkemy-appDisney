package com.alkemy.challenge.service;

import java.util.Optional;

import com.alkemy.challenge.model.Characters;

public interface CharactersService {
	
	public Iterable<Characters>findAll();
	public Iterable<Object[]>getAll();
	public Optional<Characters>findById(Integer characterId);
	public Iterable<Object[]>findByName(String name);
	public Iterable<Object[]>findByAge(Integer age);
	public boolean delete(Integer id); 
	public Characters save(Characters characters);

}

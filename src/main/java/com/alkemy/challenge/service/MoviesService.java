package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.exception.ResourceNotFoundException;
import com.alkemy.challenge.model.Movies;

public interface MoviesService {
	
	public List<Movies>findAll();
	public Optional<Movies> getById(Integer id); 
	
	/*
	public List<Movies>getAll();
	public Movies get(Integer id) throws ResourceNotFoundException;
	public Movies save (Movies movies);
	public List<Movies>findByTitle(String title);
	public List<Movies>getByOrder(String order);
	public boolean delete (Integer id); */
	
	

}

package com.alkemy.challenge.service;

import java.util.Optional;

import com.alkemy.challenge.model.Movies;

public interface MoviesService {
	
	public Iterable<Movies>findAll();
	public Iterable<Object[]>getAll();
	public Optional<Movies>findById(Integer id);
	public Movies save (Movies movies);
	public Iterable<Object[]>findByTitle(String title);
	public Iterable<Object[]>getByOrder(String order);
	public boolean delete (Integer id); 
	
	

}

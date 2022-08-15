package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.model.Movies;



public interface MoviesService {
	
	public List<Movies>findAll();
	public Optional<Movies> getById(Integer id);
	public Movies create(Movies movies);
	public Movies update(Movies movies); 
	public void delete (Integer id);
	
	public List<Movies>findByTitle(String title);
	//public List<Movies>getMovieByOrder(String order);

}

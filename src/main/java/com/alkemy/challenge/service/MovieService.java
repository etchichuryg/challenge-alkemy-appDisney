package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;


import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.model.Movie;



public interface MovieService {
	
	public List<Movie>findAll();
	public Optional<Movie> getById(Integer id);
	public Movie create(Movie movies);
	public Movie update(Movie movies); 
	public void delete (Integer id);
	
	
	public List<MovieDTO> convertMoviesToMoviesDto(List<Movie> movies);
	
	public MovieDTO findByTitle(String title);
	public List<Movie>getMovieByOrder(String order);
	public List<MovieDTO> findByIdGenre(Integer id);
	public boolean addCharacters(Integer id, Integer idCharacter);
	public void removeCharacters(Integer id, Integer idCharacter);

}

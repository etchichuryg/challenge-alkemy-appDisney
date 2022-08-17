package com.alkemy.challenge.service;


import java.util.List;
import java.util.Optional;



import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.model.Genre;


public interface GenreService {
	
	public List<Genre>findAll();
	public Genre create(Genre genders);
	public void delete(Integer id);
	public Optional<Genre> findById(Integer id);
	public Optional<GenreDTO>getMoviesByGenderIdDto(Integer id);


}

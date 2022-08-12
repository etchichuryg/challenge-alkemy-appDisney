package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.model.Genders;
import com.alkemy.challenge.model.Movies;

public interface GendersService {
	
	public Genders save (Genders genders);
	public boolean delete(Integer id);
	public Optional<Genders> findById(Integer gendersId);
	public List<Movies>getMoviesByGenderId(Integer gendersId);

}

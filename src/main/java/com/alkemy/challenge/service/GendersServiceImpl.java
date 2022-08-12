package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.Genders;
import com.alkemy.challenge.model.Movies;
import com.alkemy.challenge.repository.GendersRepository;

@Service
public class GendersServiceImpl implements GendersService {
	
	@Autowired
	GendersRepository gendersRepository; 

	@Override
	public Genders save(Genders genders) {
		return gendersRepository.save(genders);
	}

	@Override
	public boolean delete(Integer id) {
		gendersRepository.deleteById(id);
		return true;
	}

	@Override
	public Optional<Genders> findById(Integer gendersId) {
		return gendersRepository.findById(gendersId);
	}

	@Override
	public List<Movies> getMoviesByGenderId(Integer gendersId) {
		Genders gender = gendersRepository.getById(gendersId);
		if(gender!=null) {
			List<Movies>movies = gender.getMovies();
			return movies;
		} else {
			return null;
		}
	}
}

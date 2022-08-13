package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.exception.ResourceNotFoundException;
import com.alkemy.challenge.model.Movies;
import com.alkemy.challenge.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	MoviesRepository moviesRepository;

	@Override
	public List<Movies> findAll() {
		return moviesRepository.findAll();
	}
	

	public Optional<Movies> getById(Integer id) {
		return moviesRepository.findById(id);
		
	}
	/*
	@Override
	public List<Movies> getAll() {
		return moviesRepository.getAll();
	}
	
	@Override
	public Movies save(Movies movies) {
		return moviesRepository.save(movies);
	}


	@Override
	public List<Movies> getByOrder(String order) {
		if(order.equals("ASC")) {
			return moviesRepository.getAllByOrderASC();
		} else if (order.equals("DESC")) {
			return moviesRepository.getAllByOrderDESC();
		} else {
			return moviesRepository.getAll() ;
		}
		
	}

	@Override
	public boolean delete(Integer id) {
		moviesRepository.deleteById(id);
		return true;
	}

	public List<Movies>findByTitle(String title){
		return moviesRepository.findByTitle(title);
	}


	@Override
	public Movies get(Integer id) throws ResourceNotFoundException {
		return moviesRepository.getById(id);
		}

*/

}

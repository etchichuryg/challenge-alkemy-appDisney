package com.alkemy.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.Movies;
import com.alkemy.challenge.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	MoviesRepository moviesRepository;

	@Override
	public Iterable<Movies> findAll() {
		return moviesRepository.findAll();
	}

	@Override
	public Iterable<Object[]> getAll() {
		return moviesRepository.getAll();
	}

	@Override
	public Optional<Movies> findById(Integer id) {
		return moviesRepository.findById(id);
	}

	@Override
	public Movies save(Movies movies) {
		return moviesRepository.save(movies);
	}

	@Override
	public Iterable<Object[]> findByTitle(String title) {
		return moviesRepository.findByTitle(title);
	}

	@Override
	public Iterable<Object[]> getByOrder(String order) {
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

}

package com.alkemy.challenge.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer>, JpaSpecificationExecutor<Movies>{
	
	public List<Movies>findByTitle(String title);

/*	public List<Movies>getMovieByOrder(String title);
	public List<Movies>getMovieByOrder(String title,Sort sort);

   */

}

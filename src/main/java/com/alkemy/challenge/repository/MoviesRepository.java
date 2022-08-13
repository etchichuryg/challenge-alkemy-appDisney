package com.alkemy.challenge.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer>{
	
	//public List<Movies>findByTitle(String title);


   
   /*
	@Query(value = "SELECT title,image,create_date FROM movies",nativeQuery = true)
    public List<Movies> getAll();

    @Query(value = "SELECT title,image,create_date FROM movies ORDER BY create_date ASC",nativeQuery = true)
    public List<Movies> getAllByOrderASC();

    @Query(value = "SELECT title,image,create_date FROM movies ORDER BY create_date DESC",nativeQuery = true)
    public List<Movies> getAllByOrderDESC();
    
*/
   

}

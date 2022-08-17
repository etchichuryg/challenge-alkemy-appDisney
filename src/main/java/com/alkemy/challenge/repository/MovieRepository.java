package com.alkemy.challenge.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie>{
	
	public Movie findByTitle(String title);

    @Query(value = "select *from app_disney.movies order by date ASC",nativeQuery = true)
    public List<Movie> getAllByOrderASC();

    @Query(value = "select *from app_disney.movies ORDER BY date DESC",nativeQuery = true)
    public List<Movie> getAllByOrderDESC();
   
    @Query(value= "select * FROM app_disney.movies where genre_id=?" ,nativeQuery = true)
    public List<Movie> findByIdGenre (Integer genre_id);

}

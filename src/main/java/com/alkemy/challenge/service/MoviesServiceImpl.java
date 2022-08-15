package com.alkemy.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.MoviesDto;
import com.alkemy.challenge.model.Movies;
import com.alkemy.challenge.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	MoviesRepository moviesRepository;
	/*@Autowired
	MoviesDto moviesDto;
	*/
	
	@Override
	public List<Movies> findAll() {
		return moviesRepository.findAll();
	}
	
	public Optional<Movies> getById(Integer id) {
		return moviesRepository.findById(id);
		
	}
	
	public Movies create (Movies movies) {
		return moviesRepository.save(movies);
	}
	
	public void delete (Integer id) {
		moviesRepository.deleteById(id);
	}
	public Movies update(Movies movies) {
		return moviesRepository.save(movies); 
	}
	public List<Movies>findByTitle(String title){
		return moviesRepository.findByTitle(title);
	}
	
	/*public List<MoviesDto> getMovieByOrder(String title, String order){
		if (order == null) throw new IllegalArgumentException();
		return (order != null && order.equals("ASC"))
				? MoviesDto.mapToDto(moviesRepository.getMovieByOrder(title, Sort.by(Sort.Direction.ASC, "create_date")))
						:(order != null && order.equals("DESC"))
				? MoviesDto.mapToDto(moviesRepository.getMovieByOrder(title, Sort.by(Sort.Direction.DESC, "create_date")))
						:MoviesDto.mapToDto(moviesRepository.getMovieByOrder(title)); 
	}

	@Override
	public List<Movies> getMovieByOrder(String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
*/

}

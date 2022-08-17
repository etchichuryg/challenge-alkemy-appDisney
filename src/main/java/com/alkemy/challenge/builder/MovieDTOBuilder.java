package com.alkemy.challenge.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.model.Movie;

@Component
public class MovieDTOBuilder {
	
	public MovieDTO convertEntityToDto(Movie movie) {
		ModelMapper modelMapper = new ModelMapper();
		MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
		return movieDTO; 
	}
	
	public Movie convertDtoToEntity(MovieDTO movieDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Movie movie = modelMapper.map(movieDTO, Movie.class);
		return movie; 
	}

}

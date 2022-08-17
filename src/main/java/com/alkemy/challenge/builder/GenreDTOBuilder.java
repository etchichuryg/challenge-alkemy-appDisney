package com.alkemy.challenge.builder;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.model.Genre;

@Component
public class GenreDTOBuilder {
	
	public GenreDTO convertEntityToDto(Genre genre) {
		ModelMapper modelMapper = new ModelMapper();
		GenreDTO genreDTO = modelMapper.map(genre, GenreDTO.class);
		return genreDTO;
	}
	
	public Genre convertDtoToEntity(GenreDTO genreDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Genre genre = modelMapper.map(genreDTO, Genre.class);
		return genre; 
	}
	

}

package com.alkemy.challenge.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.model.Genre;
import com.alkemy.challenge.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	GenreRepository genreRepository; 

	public List<Genre>findAll(){
		return genreRepository.findAll();
	}
	@Override
	public Genre create(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public void delete(Integer id) {
		genreRepository.deleteById(id);
	}

	@Override
	public Optional<Genre> findById(Integer id) {
		return genreRepository.findById(id);
	}


	public Optional<GenreDTO> getMoviesByGenderIdDto(Integer id) {
		Optional<Genre> genre = genreRepository.findById(id);
		ModelMapper modelMapper = new ModelMapper();
		GenreDTO genreDTO = modelMapper.map(genre.get(), GenreDTO.class);
		return Optional.of(genreDTO); 
	}


	
}

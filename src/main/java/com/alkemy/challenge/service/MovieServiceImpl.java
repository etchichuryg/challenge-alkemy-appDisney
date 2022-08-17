package com.alkemy.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.builder.MovieDTOBuilder;
import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.model.Characters;
import com.alkemy.challenge.model.Movie;
import com.alkemy.challenge.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	MovieDTOBuilder movieDTOBuilder;
	@Autowired
	CharacterService characterService;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Optional<Movie> getById(Integer id) {
		return movieRepository.findById(id);

	}

	public Movie create(Movie movies) {
		return movieRepository.save(movies);
	}

	public void delete(Integer id) {
		movieRepository.deleteById(id);
	}

	public Movie update(Movie movies) {
		return movieRepository.save(movies);
	}

	public List<MovieDTO> convertMoviesToMoviesDto(List<Movie> movies) {
		List<MovieDTO> movieDto = new ArrayList<>();
		for (Movie m : movies) {
			MovieDTO mov = movieDTOBuilder.convertEntityToDto(m);
			movieDto.add(mov);
		}
		return movieDto;
	}

	public MovieDTO findByTitle(String title) {
		Movie m = movieRepository.findByTitle(title);
		return movieDTOBuilder.convertEntityToDto(m);
	}

	public List<Movie> getMovieByOrder(String order) {
		if (order.equals("ASC")) {
			return movieRepository.getAllByOrderASC();
		} else if (order.equals("DESC")) {
			return movieRepository.getAllByOrderDESC();
		} else {
			return movieRepository.findAll();
		}

	}

	public List<MovieDTO> findByIdGenre(Integer id) {
		List<Movie> mov = movieRepository.findByIdGenre(id);
		List<MovieDTO> movieDto = new ArrayList<>();
		for (Movie m : mov) {
			movieDto.add(movieDTOBuilder.convertEntityToDto(m));
		}
		return movieDto;
	}

	@Override
	public boolean addCharacters(Integer id, Integer idCharacter) {
	
		Movie movie = movieRepository.getReferenceById(id);
		Characters characters = characterService.getById(idCharacter);
		List<Characters> chs = movie.getCharacters();
		if (!chs.contains(characters)) {
		movie.addCharacter(characters);
		characters.addMovie(movie);
		movieRepository.save(movie);
		return true;
		}
		return false;
		}

	@Override
	public void removeCharacters(Integer id, Integer idCharacter) {
	
		Movie movie = movieRepository.getReferenceById(id);
		Characters characters = characterService.getById(idCharacter);
		movie.removeCharacter(characters);
		characters.removeMovie(movie);
		movieRepository.save(movie);
	}
}

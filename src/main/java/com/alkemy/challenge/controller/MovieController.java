package com.alkemy.challenge.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.builder.MovieDTOBuilder;
import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.model.Movie;
import com.alkemy.challenge.repository.MovieRepository;
import com.alkemy.challenge.service.MovieService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:4200")
@SecurityRequirement(name = "bearerAuth")
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	MovieDTOBuilder movieDTOBuilder;

	@GetMapping()
	public ResponseEntity<List<Movie>> findAll() {
		return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movie>> findById(@PathVariable Integer id) {
		Optional<Movie> result = movieRepository.findById(id);
		return new ResponseEntity<Optional<Movie>>(result, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Movie newMovies )throws IOException {
		movieService.create(newMovies);
		return new ResponseEntity<String>("Movie create", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Movie movies) {
		movieService.update(movies);
		return new ResponseEntity<String>("Movie update", HttpStatus.OK);
	}

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
		movieService.delete(id);
		return new ResponseEntity<String>("Delete Done!", HttpStatus.OK);
	}

	@GetMapping(params = "name")
	public MovieDTO findByTitle(@RequestParam("name") String title) {
		return movieService.findByTitle(title);
	}

	@GetMapping(params = "order")
	public List<MovieDTO> getMoviesByOrder(@RequestParam("order") String order) {
		List<Movie> movies = movieService.getMovieByOrder(order);
		return movieService.convertMoviesToMoviesDto(movies);
	}

	@GetMapping(value = "", params = "genre")
	public List<MovieDTO> getByGenere(@RequestParam("genre") Integer id) {
		return movieService.findByIdGenre(id);
	}
	
	@PostMapping("{id}/characters/{idCharacter}")
	public ResponseEntity<Void> addCharacters(@PathVariable Integer id, @PathVariable Integer idCharacter) {
    boolean isProcessed = movieService.addCharacters(id, idCharacter);
    if(isProcessed) {
    return ResponseEntity.status(HttpStatus.OK).build();
    }else {
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
    }
  }

	@DeleteMapping("{id}/characters/{idCharacter}")
	public ResponseEntity<Void> removeCharacters(@PathVariable Integer id, @PathVariable Integer idCharacter) {
    movieService.removeCharacters(id, idCharacter);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}

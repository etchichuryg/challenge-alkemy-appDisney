package com.alkemy.challenge.controller;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.dto.MoviesDto;
import com.alkemy.challenge.model.Movies;
import com.alkemy.challenge.repository.MoviesRepository;
import com.alkemy.challenge.service.GendersService;
import com.alkemy.challenge.service.MoviesService;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:4200")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;
	@Autowired
	private GendersService gendersService;
	@Autowired
	private MoviesRepository moviesRepository;

	@GetMapping()
	public ResponseEntity<List<Movies>> findAll() {
		return new ResponseEntity<>(moviesService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movies>> findById(@PathVariable Integer id) {
		Optional<Movies> result = moviesRepository.findById(id);
		return new ResponseEntity<Optional<Movies>>(result, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Movies newMovies) {
		moviesService.create(newMovies);
		return new ResponseEntity<String>("Movie create", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Movies movies) {
		moviesService.update(movies);
		return new ResponseEntity<String>("Movie update", HttpStatus.OK);
	}

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
		moviesService.delete(id);
		return new ResponseEntity<String>("Delete Done!", HttpStatus.OK);
	}

	@GetMapping(params = "name")
	public ResponseEntity<List<Movies>> findByTitle(@RequestParam("name") String title) {
		return new ResponseEntity<>(moviesService.findByTitle(title), HttpStatus.OK);
	}

/*	@GetMapping(params = "order")
	public ResponseEntity<List<MoviesDto>> getMoviesByOrder(@RequestParam("order") String order) {
		Movies movies = (Movies) moviesService.getMovieByOrder(order);
		
		ModelMapper model = new ModelMapper();
		MoviesDto dto = model.map(movies, MoviesDto.class);
		return new ResponseEntity<List<MoviesDto>>( HttpStatus.OK);
	}
*/
/*	@GetMapping(value = "", params = "genre")
	public List<Movies> getByGenere(@RequestParam("genre") Integer genderId) {
		return gendersService.getMoviesByGenderId(genderId);
	}*/

}

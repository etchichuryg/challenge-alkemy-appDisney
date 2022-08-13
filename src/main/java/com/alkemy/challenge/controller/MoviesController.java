package com.alkemy.challenge.controller;

import java.io.IOException;
import java.nio.file.*;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
		moviesService.delete(id);
		return new ResponseEntity<String>("Delete Done!", HttpStatus.OK);
	}

	/*
	 * @GetMapping(params = "name") public ResponseEntity<List<Movies>>
	 * findByTitle(@RequestParam("name") String title) { return new
	 * ResponseEntity<>(moviesService.findByTitle(title), HttpStatus.OK); }
	 * 
	 * @GetMapping(params = "order") public ResponseEntity<List<Movies>>
	 * getByOrder(@RequestParam("order") String order) { return new
	 * ResponseEntity<>(moviesService.getByOrder(order), HttpStatus.OK); }
	 * 
	 * @GetMapping(value = "", params = "genderId") public List<Movies>
	 * getByGenere(@RequestParam("genderId") Integer genderId) { return
	 * gendersService.getMoviesByGenderId(genderId); }
	 */

}
/*
 * @PostMapping("save") public Movies save(@RequestParam("file") MultipartFile
 * image, @ModelAttribute Movies movies) { if (!image.isEmpty()) { Path
 * imagesPath = Paths.get("src//main//resources//static//images"); String
 * absolutPath = imagesPath.toFile().getAbsolutePath(); try { byte[] bytes =
 * image.getBytes(); Path route = Paths.get(absolutPath +
 * image.getOriginalFilename()); Files.write(route, bytes);
 * movies.setImage(image.getOriginalFilename()); } catch (IOException e) {
 * e.printStackTrace(); } } return moviesService.save(movies); }
 */

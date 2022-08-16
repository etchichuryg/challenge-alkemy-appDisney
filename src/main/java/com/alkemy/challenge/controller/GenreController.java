package com.alkemy.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.model.Genre;
import com.alkemy.challenge.service.GenreService;

@RestController
@RequestMapping("/genders")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {

	@Autowired
	GenreService genreService;

	@PostMapping
	public ResponseEntity<Genre> save(@RequestBody Genre genre) {
		Genre genreSave = genreService.create(genre);
		return ResponseEntity.status(HttpStatus.CREATED).body(genreSave);
	}

}

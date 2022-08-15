package com.alkemy.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.builder.CharacterDTOBuilder;
import com.alkemy.challenge.model.Characters;
import com.alkemy.challenge.repository.CharacterRepository;
import com.alkemy.challenge.service.CharacterService;

@RestController
@RequestMapping("/characters")
@CrossOrigin(origins="http://localhost:4200")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	@Autowired
	private CharacterRepository characterRepository;
	@Autowired
	CharacterDTOBuilder characterDTOBuilder;
	
	@GetMapping()
	public ResponseEntity<List<Characters>> findAll() {
		return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
	}
	
	/*@GetMapping("{/id}")
	public ResponseEntity<Optional<Characters>> findById(@PathVariable Integer id){
		Optional<Characters> result = characterRepository.findById(id);
		return new ResponseEntity<Optional<Characters>>(result, HttpStatus.OK);
	}
	*/
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Characters newCharacters){
		characterService.create(newCharacters);
		return new ResponseEntity<String>("Character create", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Characters characters){
		characterService.update(characters);
		return new ResponseEntity<String>("Character update", HttpStatus.OK);
	}
	
/*	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<String> delete(@PathVariable (value= "id") Integer id){
		characterService.delete(id);
		return new ResponseEntity<String>("Delete Done!", HttpStatus.OK);
	}
	*/
	
	
}

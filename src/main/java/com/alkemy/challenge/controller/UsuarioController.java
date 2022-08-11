package com.alkemy.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.challenge.exception.ResourceNotFoundException;
import com.alkemy.challenge.model.Usuario;
import com.alkemy.challenge.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "htpp://localhost:4200")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> listUsuarios(){
		List<Usuario> theUsuarios = usuarioService.getUsuario();
		return new ResponseEntity<List<Usuario>>(theUsuarios, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Integer> save(@RequestBody Usuario theUsuario){
		theUsuario = usuarioService.saveUsuario(theUsuario);
		return new ResponseEntity<Integer>(theUsuario.getId(), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Usuario theUsuario){
		usuarioService.saveUsuario(theUsuario);
		return new ResponseEntity<String>("Usuario update", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) throws ResourceNotFoundException {
			Usuario theUsuario = usuarioService.getUsuario(id);
			return new ResponseEntity<Usuario>(theUsuario, HttpStatus.OK);
	}
	
	/*@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarioByName(@RequestParam Integer id, @RequestParam String nombre) throws ResourceNotFoundException){
		return new ResponseEntity<List<Usuario>> (result, HttpStatus.OK);
	}*/
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody Usuario theUsuario){
		usuarioService.deleteUsuario(theUsuario.getId());
		return new ResponseEntity<String>("Delete Usuario Done!", HttpStatus.OK);
	}
}

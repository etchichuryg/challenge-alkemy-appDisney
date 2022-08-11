package com.alkemy.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.exception.ResourceNotFoundException;
import com.alkemy.challenge.model.Usuario;
import com.alkemy.challenge.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getUsuario() {
		return usuarioRepository.findAll();
	}

	@Transactional
	public Usuario saveUsuario(Usuario theUsuario) {
		theUsuario = usuarioRepository.save(theUsuario);
		return theUsuario;
	}

	@Override
	public Usuario getUsuario(int theId) throws ResourceNotFoundException {
		return usuarioRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
			}

	@Transactional
	public void deleteUsuario(int theId) {
		usuarioRepository.deleteById(theId);
		
	}

	public List<Usuario> findByName(String nombre) {
		return usuarioRepository.findByName(nombre);
	}

	

}

package com.alkemy.challenge.service;

import java.util.List;

import com.alkemy.challenge.exception.ResourceNotFoundException;
import com.alkemy.challenge.model.Usuario;

public interface UsuarioService {
	public List<Usuario> getUsuario();
	public Usuario saveUsuario (Usuario theUsuario);
	public Usuario getUsuario (int theId) throws ResourceNotFoundException;
	public void deleteUsuario(int theId); 
	public List<Usuario> findByName(String nombre);
}

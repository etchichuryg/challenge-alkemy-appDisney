package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.model.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	public List<Usuario> findByName(String nombre);
}

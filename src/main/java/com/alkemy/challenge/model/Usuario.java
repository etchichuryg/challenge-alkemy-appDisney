package com.alkemy.challenge.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String username;
	private String email;
	private String direccion;
	private String telefono;
	private String rol;
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Personaje> personajes;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pelicula> peliculas;
	
	
	public Usuario() {
		
	}


	public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono,
			String rol, String password, List<Personaje> personajes, List<Pelicula> peliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.rol = rol;
		this.password = password;
		this.personajes = personajes;
		this.peliculas = peliculas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Personaje> getPersonajes() {
		return personajes;
	}


	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}


	public List<Pelicula> getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", rol=" + rol + ", password=" + password
				+ ", personajes=" + personajes + ", peliculas=" + peliculas + "]";
	}

	

	
	
}

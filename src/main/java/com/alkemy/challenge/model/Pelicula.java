package com.alkemy.challenge.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )  
	private Integer id;
	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
	
	@ManyToOne
	private Usuario usuario; 
	@ManyToOne
	private Personaje personaje;
	@OneToMany(mappedBy = "pelicula")
	private List<Genero> genero; 
	
	public Pelicula() {
		
	}

	public Pelicula(Integer id, String imagen, String titulo, Date fechaCreacion, int calificacion, Usuario usuario,
			Personaje personaje, List<Genero> genero) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.usuario = usuario;
		this.personaje = personaje;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", imagen=" + imagen + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion
				+ ", calificacion=" + calificacion + ", usuario=" + usuario + ", personaje=" + personaje + ", genero="
				+ genero + "]";
	}
	
	

	
	
	
}

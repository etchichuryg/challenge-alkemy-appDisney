package com.alkemy.challenge.model;

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
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String imagen;
	private String nombre;
	private int edad;
	private int peso;
	private String historia;
	private String peliculaSeriaAsociada;
	
	@ManyToOne
	private Usuario usuario; 
	@OneToMany(mappedBy = "personaje")
	private List<Pelicula> peliculas; 
	
	
	public Personaje() {
	}


	public Personaje(Integer id, String imagen, String nombre, int edad, int peso, String historia,
			String peliculaSeriaAsociada, Usuario usuario, List<Pelicula> peliculas) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculaSeriaAsociada = peliculaSeriaAsociada;
		this.usuario = usuario;
		this.peliculas = peliculas;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public String getPeliculaSeriaAsociada() {
		return peliculaSeriaAsociada;
	}


	public void setPeliculaSeriaAsociada(String peliculaSeriaAsociada) {
		this.peliculaSeriaAsociada = peliculaSeriaAsociada;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Pelicula> getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}


	@Override
	public String toString() {
		return "Personaje [id=" + id + ", imagen=" + imagen + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso
				+ ", historia=" + historia + ", peliculaSeriaAsociada=" + peliculaSeriaAsociada + ", usuario=" + usuario
				+ ", peliculas=" + peliculas + "]";
	}

	
	

}

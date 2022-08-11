package com.alkemy.challenge.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Genero {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String imagen;
	
	@ManyToOne
	private Pelicula pelicula; 
	
	public Genero() {
		
	}
	
	public Genero(Integer id, String nombre, String imagen, Pelicula pelicula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.pelicula = pelicula;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", pelicula=" + pelicula + "]";
	}
	
	

}

package com.alkemy.challenge.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="genders")
public class Genre {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idGenre;
	
	@NotEmpty
	private String name;
	
	@Lob
	@JsonIgnore
	private byte[] image;
	
	@JsonIgnoreProperties(value= {"genre","character"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Movie> movies;
	
	public Genre() {
		this.movies = new ArrayList<>();
		
	}

	
	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@JsonIgnoreProperties(value= {"genre"}, allowSetters=true)
	public List<Movie> getMovies() {
		return movies;
	}
	

	public void setMovies(List<Movie> listMovies) {
		this.movies.clear();
		listMovies.forEach(this::addMovie);
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
		movie.setGenre(this);
		
	}
	public void removeMovie(Movie movie) {
		movies.remove(movie);
		movie.setGenre(null);
	}
	
	@JsonIgnore
	public Integer getImagenHashCode() {
		return (this.image!=null) ? this.image.hashCode() : null;
	}

	@Override
	public String toString() {
		return "Genre [idGenre=" + idGenre + ", name=" + name + ", image=" + image + ", movies=" + movies + "]";
	}
	
}

package com.alkemy.challenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "characters")

public class Characters implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idCharacter;

	@NotEmpty
	private String name;

	@JsonIgnore
	@Lob
	private byte[] image;

	@NotNull
	@Min(1)
	private Integer age;

	@NotNull
	@Min(1)
	private Integer weight;

	@NotEmpty
	private String history;

	@JsonIgnoreProperties(value = { "characters" }, allowSetters = true)
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "characters_movies", joinColumns = {
			@JoinColumn(name = "id_character", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_movie", nullable = false) })
	private List<Movie> movies;

	public Characters() {
		this.movies = new ArrayList<>();

	}

	public Integer getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies.clear();
		movies.forEach(this::addMovie);
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
		movie.getCharacters().add(this);
	}

	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		movie.getCharacters().remove(this);
	}

	@JsonIgnore
	public Integer getImagenHashCode() {
		return (this.image != null) ? this.image.hashCode() : null;
	}

	@Override
	public String toString() {
		return "Characters [idCharacter=" + idCharacter + ", name=" + name + ", image=" + Arrays.toString(image)
				+ ", age=" + age + ", weight=" + weight + ", history=" + history + "]";
	}

	
	public void setNewCharacter(Movie movie, Integer idCharacters  ) {
		this.idCharacter = idCharacters;
		this.movies.add(movie);
		this.movies.remove(movie);
		
	}
	

}

package com.alkemy.challenge.dto;

import java.io.Serializable;
import java.util.List;

public class GenreDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	
	private List<MovieDTO> movies;
	
	GenreDTO(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	
	

}

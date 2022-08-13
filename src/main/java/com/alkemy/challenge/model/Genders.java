package com.alkemy.challenge.model;

import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name="Genders.findAll", query="SELECT genders FROM Genders genders")
@Table
public class Genders {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="genders_id")
	private Integer id;
	private String name;
	private String image;
	
	
	@OneToMany(mappedBy ="genders")
	private List<Movies> movies;
	
	public Genders() {
		
	}

	public Genders(Integer id, String name, String image, List<Movies> movies) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.movies = movies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Genders [id=" + id + ", name=" + name + ", image=" + image + ", movies=" + movies + "]";
	}
	
}

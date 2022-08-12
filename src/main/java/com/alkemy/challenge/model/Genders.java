package com.alkemy.challenge.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table
public class Genders {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer genderid;
	private String name;
	private String image;
	
	
	@OneToMany(mappedBy ="genders")
	private List<Movies> movies;
	
	public Genders() {
		
	}

	public Genders(Integer genderid, String name, String image, List<Movies> movies) {
		super();
		this.genderid = genderid;
		this.name = name;
		this.image = image;
		this.movies = movies;
	}

	public Integer getGenderid() {
		return genderid;
	}

	public void setGenderid(Integer genderid) {
		this.genderid = genderid;
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
		return "Genders [genderid=" + genderid + ", name=" + name + ", image=" + image + ", movies=" + movies + "]";
	}
	
}

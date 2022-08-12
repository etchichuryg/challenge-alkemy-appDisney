package com.alkemy.challenge.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Movies {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer movieid;
	private String title;
	private String image;
	private Date create_date;
	private Integer rating;
	
	@ManyToMany
	private List<Characters> characters;
	@ManyToOne
	private Genders genders;
	
	public Movies() {
		
	}
	public Movies(Integer movieid, String title, String image, Date create_date, Integer rating,
			List<Characters> characters, Genders genders) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.image = image;
		this.create_date = create_date;
		this.rating = rating;
		this.characters = characters;
		this.genders = genders;
	}
	public Integer getMovieid() {
		return movieid;
	}
	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public List<Characters> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Characters> characters) {
		this.characters = characters;
	}
	public Genders getGenders() {
		return genders;
	}
	public void setGenders(Genders genders) {
		this.genders = genders;
	}
	@Override
	public String toString() {
		return "Movies [movieid=" + movieid + ", title=" + title + ", image=" + image + ", create_date=" + create_date
				+ ", rating=" + rating + ", characters=" + characters + ", genders=" + genders + "]";
	}
	
	
}

package com.alkemy.challenge.model;




import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movies")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMovie;
	
	@NotEmpty
	private String title;
	
	@JsonIgnore
	@Lob
	private byte[] image;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Min(1)
	@Max(5)
	private Integer rating;
	
	@JsonIgnoreProperties(value= {"movies"}, allowSetters=true)
	@ManyToMany (fetch=FetchType.LAZY,  mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Characters> characters;
	
	
	
	@JsonIgnoreProperties(value= {"movies", "characters"}, allowSetters=true)
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_genre")
	@JsonIgnore
	private Genre genre;
	
	public Movie() {
		this.characters = new ArrayList<>();
		
	}
	
	@PrePersist
	public void PrePersist() {
		this.date= new Date();
	}
	
	public Movie( String title, byte[] image, Date date) {
		super();
		this.title = title;
		this.image = image;
		this.date = date;
	}	
	
	public Integer getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public void setCharacters(List<Characters> listCharacters) {
		this.characters.clear();
		listCharacters.forEach(this::addCharacter);
	}
	public void addCharacter(Characters character) {
		this.characters.add(character);
	}
	public void removeCharacter(Characters character) {
		this.characters.remove(character);
	}
	@JsonIgnore
	public Integer getImagenHashCode() {
		return (this.image!=null) ? this.image.hashCode() : null;
	}
	
	@JsonIgnoreProperties(value= {"genre","characters"}, allowSetters=true)
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Movie)) {
			return false;
		}
		
		Movie a  = (Movie) obj;
		
		return this.idMovie !=null && this.idMovie.equals(a.getIdMovie());
	}
	@Override
	public String toString() {
		return "Movies [idMovie=" + idMovie + ", title=" + title + ", image=" + image + ", date=" + date
				+", rating=" + rating + ", characters=" + characters + ", genre=" + genre + "]";
	}
	
	
}

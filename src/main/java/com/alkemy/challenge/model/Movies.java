package com.alkemy.challenge.model;




import java.io.Serializable;
import java.util.Date; 
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Movies.findAll", query="SELECT movies FROM Movies movies")
@Table
public class Movies implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movies_id")
	private Integer id;
	private String title;
	private String image;
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	private Integer rating;
	
	@ManyToMany
	private List<Characters> characters;
	@ManyToOne
	private Genders genders;
	
	public Movies() {
		
	}
	public Movies(Integer id, String title, String image, Date createDate, Integer rating,
			List<Characters> characters, Genders genders) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.createDate = createDate;
		this.rating = rating;
		this.characters = characters;
		this.genders = genders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return "Movies [id=" + id + ", title=" + title + ", image=" + image + ", create_date=" + createDate
				+", rating=" + rating + ", characters=" + characters + ", genders=" + genders + "]";
	}
	
	
}

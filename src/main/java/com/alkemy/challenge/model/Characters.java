package com.alkemy.challenge.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table
public class Characters {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	private Integer characterid;
	private String name;
	private String image;
	private Integer age;
	private Integer weight;
	private String history;
	
	@ManyToMany
	@JoinTable(name="characters_movies",
			joinColumns= { @JoinColumn(name="characterid", nullable=false)},
			inverseJoinColumns= {@JoinColumn(name="id", nullable=false)})
	private List<Movies> filmsID; 
	
	public Characters(){
		
	}

	public Characters(Integer characterid, String name, String image, Integer age, Integer weight, String history,
			Movies movies) {
		super();
		this.characterid = characterid;
		this.name = name;
		this.image = image;
		this.age = age;
		this.weight = weight;
		this.history = history;
	
	}

	public Integer getCharacterid() {
		return characterid;
	}

	public void setCharacterid(Integer characterid) {
		this.characterid = characterid;
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

	@Override
	public String toString() {
		return "Characters [characterid=" + characterid + ", name=" + name + ", image=" + image + ", age=" + age
				+ ", weight=" + weight + ", history=" + history + "]";
	}
	
	
	

}

package com.alkemy.challenge.dto;

import java.util.ArrayList;
import java.util.List;

import com.alkemy.challenge.model.Characters;

public class CharacterDTO {
	private String name;
	private byte[] image;


	public CharacterDTO() {

	}


	public CharacterDTO(String name, byte[] image) {
		super();
		this.name = name;
		this.image = image;
	}
	
	public CharacterDTO(Characters character) {
		this.name = character.getName();
		this.image = character.getImage();
	}
	
	public static List<CharacterDTO> mapToDto (List<Characters>characterList){
		List<CharacterDTO> list = new ArrayList<>();
		for(Characters c : characterList) {
			list.add(new CharacterDTO(c));
		}
		return list;
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
	
	

}

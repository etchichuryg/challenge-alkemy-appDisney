package com.alkemy.challenge.service;

import java.util.List;


import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.model.Characters;

public interface CharacterService {
	
	public List<Characters>findAll();
	public Characters getById(Integer id);
	public Characters create (Characters characters);
	public Characters update (Characters characters);
	public void delete (Integer id);
	
	
	public List<CharacterDTO> convertCharactersToCharactersDto(List<Characters> characters);
	
	public List<Characters>getAll();
	public CharacterDTO findByName(String name);
	public CharacterDTO findByAge(Integer age);
	public List<CharacterDTO> findByMovies(Integer id);
	
	

}

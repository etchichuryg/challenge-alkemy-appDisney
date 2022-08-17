package com.alkemy.challenge.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.model.Characters;

@Component
public class CharacterDTOBuilder {
	
	public CharacterDTO convertEntityToDto(Characters c) {
		ModelMapper modelMapper = new ModelMapper();
		CharacterDTO characterDTO = modelMapper.map(c, CharacterDTO.class);
		return characterDTO;
	}
	
	public Characters convertDtoToEntity (CharacterDTO characterDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Characters character = modelMapper.map(characterDTO, Characters.class);
		return character;
	}



}

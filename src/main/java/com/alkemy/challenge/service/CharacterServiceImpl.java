package com.alkemy.challenge.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.builder.CharacterDTOBuilder;
import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.model.Characters;
import com.alkemy.challenge.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	CharacterDTOBuilder characterDTOBuilder;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Characters> findAll() {
		return characterRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Characters getById(Integer id) {
		return characterRepository.getById(id);
	}

	@Override
	public Characters create(Characters characters) {
		return characterRepository.save(characters);
	}

	@Override
	public Characters update(Characters characters) {
		return characterRepository.save(characters);
	}

	@Override
	public void delete(Integer id) {
		characterRepository.deleteById(id);

	}

	@Override
	public List<CharacterDTO> convertCharactersToCharactersDto(List<Characters> characters) {
		List<CharacterDTO> characterDto = new ArrayList<>();
		for (Characters c : characters) {
			CharacterDTO ch = characterDTOBuilder.convertEntityToDto(c);
			characterDto.add(ch);
		}
		return characterDto;
	}

	@Override
	public List<Characters> getAll() {
		return null;
	}

	@Override
	public CharacterDTO findByName(String name) {
		Characters ch = characterRepository.findByName(name);
		return characterDTOBuilder.convertEntityToDto(ch);
	}

	@Override
	public CharacterDTO findByAge(Integer age) {
		Characters ch = characterRepository.findByAge(age);
	 return characterDTOBuilder.convertEntityToDto(ch);
	
	}

	@Override
	public List<CharacterDTO> findByMovies(Integer id) {
		List<Characters> ch = characterRepository.findByMovies(id);
		List<CharacterDTO> characterDto = new ArrayList<>();
		for (Characters c : ch) {
			characterDto.add(characterDTOBuilder.convertEntityToDto(c));
		}
		return characterDto;
	}
	
	
}

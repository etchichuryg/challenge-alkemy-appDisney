package com.alkemy.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alkemy.challenge.model.Characters;
import com.alkemy.challenge.repository.CharactersRepository;

public class CharactersServiceImpl implements CharactersService {

	@Autowired
	CharactersRepository charactersRepository;
	
	@Override
	public Iterable<Characters> findAll() {
		return charactersRepository.findAll();
	}

	@Override
	public Iterable<Object[]> getAll() {
		return charactersRepository.getAll();
	}

	@Override
	public Optional<Characters> findById(Integer characterId) {
		return charactersRepository.findById(characterId);
	}

	@Override
	public Iterable<Object[]> findByName(String name) {
		return charactersRepository.findByName(name);
	}

	@Override
	public Iterable<Object[]> findByAge(Integer age) {
		return charactersRepository.findByAge(age);
	}

	@Override
	public boolean delete(Integer id) {
		charactersRepository.deleteById(id);
		return true;
	}

	@Override
	public Characters save(Characters characters) {
		return charactersRepository.save(characters);
	}
	
}

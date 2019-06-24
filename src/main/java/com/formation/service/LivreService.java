package com.formation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Livre;
import com.formation.repository.LivreRepository;

@Component
public class LivreService {

	@Autowired
	private LivreRepository livreRepository;

	@Transactional
	public void add(Livre livre) {
		livreRepository.save(livre);
	}
	
	@Transactional
	public void update(Livre livre) {
		livreRepository.save(livre);
	}
	
	public void delete(Livre livre) {
		livreRepository.delete(livre);
	}

	@Transactional(readOnly = true)
	public List<Livre> findAll() {
		return livreRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Livre> livres) {
		for (Livre livre : livres)
			livreRepository.save(livre);
	}
	
	@Transactional(readOnly = true)
	public List<Livre> findByTitre(String titre) {
		return livreRepository.findByTitre(titre);
	}

}

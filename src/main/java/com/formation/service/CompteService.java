package com.formation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Compte;
import com.formation.repository.CompteRepository;

@Component
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;

	@Transactional
	public void add(Compte compte) {
		compteRepository.save(compte);
	}

	@Transactional
	public void update(Compte compte) {
		compteRepository.save(compte);
	}

	@Transactional
	public void delete(Compte compte) {
		compteRepository.delete(compte);
	}

	@Transactional(readOnly = true)
	public List<Compte> findAll() {
		return compteRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Compte> comptes) {
		for (Compte compte : comptes)
			compteRepository.save(compte);
	}

	@Transactional(readOnly = true)
	public List<Compte> findByNom(String nom) {
		return compteRepository.findByNom(nom);
	}
}

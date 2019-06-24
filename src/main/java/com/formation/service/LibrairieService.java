package com.formation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Librairie;
import com.formation.repository.LibrairieRepository;

@Component
public class LibrairieService {
	
	@Autowired
	private LibrairieRepository librairieRepository;
	
	@Transactional
	public void add(Librairie librairie) {
		librairieRepository.save(librairie);
	}
	
	@Transactional
	public void update(Librairie librairie) {
		librairieRepository.save(librairie);
	}

	@Transactional
	public void delete(Librairie librairie) {
		librairieRepository.delete(librairie);
	}
	
	@Transactional(readOnly=true)
	public List<Librairie> findAll(){
		return librairieRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Librairie> librairies) {
		for(Librairie librairie:librairies)
			librairieRepository.save(librairie);
	}
	
	@Transactional(readOnly=true)
	public List<Librairie> findByNom(String nom){
		return librairieRepository.findByNom(nom);
	}
}

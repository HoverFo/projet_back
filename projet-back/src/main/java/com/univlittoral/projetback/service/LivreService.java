package com.univlittoral.projetback.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.projetback.dto.TypeEnum;
import com.univlittoral.projetback.entity.AuteurEntity;

import com.univlittoral.projetback.entity.LivreEntity;

import com.univlittoral.projetback.repository.AuteurRepository;
import com.univlittoral.projetback.repository.LivreRepository;

@Service
public class LivreService {
	
	@Autowired
	private LivreRepository repo;
	
	@Autowired
	private AuteurRepository AuteurRepo;
	
	
	public List<LivreEntity> findAllLivres(){
		return repo.findAllLivresRepo();
	}
	
	
		public List<AuteurEntity> findAllAuteurs(){
			return AuteurRepo.findAll();
	}
	
	
	
    public LivreEntity findLivreById(Integer id){
        return repo.findById(id).orElse(null);
    }
    
  
    public AuteurEntity findAuteurById(Integer id){
        return AuteurRepo.findById(id).orElse(null);
    }
    

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
    

    public void saveOrUpdateLivre(LivreEntity livre) {
        repo.save(livre);
    }

    public List<LivreEntity> findByGenre(TypeEnum genre){
		return repo.findLivresByGenre(genre);
	}

    public ArrayList<String> findGenre() {
    	return repo.findGenre();
    }

    public ArrayList<Integer> findNbGenre() {
    	return repo.findGenreNb();
    }
}
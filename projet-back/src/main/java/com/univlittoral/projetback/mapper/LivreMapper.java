package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.LivreDTO;
import com.univlittoral.projetback.dto.LivreRequestSaveDTO;
import com.univlittoral.projetback.entity.LivreEntity;





public class LivreMapper {

		public static LivreDTO map(LivreEntity entity) {
			LivreDTO livre = new LivreDTO();
			  
			  
			livre.setId(entity.getId()); 
			livre.setNom(entity.getNom());
			livre.setEditeur(entity.getEditeur());
			livre.setNbPages(entity.getNbPages());
			livre.setDateParution(entity.getDateParution()); 
			livre.setLieuParution(entity.getLieuParution()); 
			livre.setAuteur(entity.getAuteur()); 
			livre.setGenre(entity.getGenre()); 

			  return livre;
			 
		}
		

		public static List<LivreDTO> map(List<LivreEntity> LivreEntity){
			if(null == LivreEntity) {
				return null;
			}
			List<LivreDTO> result = new ArrayList<LivreDTO>();
			for(final LivreEntity livre : LivreEntity) {
				result.add(LivreMapper.map(livre));
			}
			
			return result;
		}
		
		//Ajout d'un livre
	    public static LivreEntity addLivre(LivreRequestSaveDTO reqAddLivre) {
	    	
	        LivreEntity livreAdd = new LivreEntity();
	        
	        livreAdd.setNom(reqAddLivre.getNom());
	        livreAdd.setDateParution(reqAddLivre.getDateParution());
	        livreAdd.setEditeur(reqAddLivre.getEditeur());
	        livreAdd.setGenre(reqAddLivre.getGenre());
	        livreAdd.setLieuParution(reqAddLivre.getLieuParution());
	        livreAdd.setNbPages(reqAddLivre.getNbPages());
	        livreAdd.setAuteur(reqAddLivre.getAuteur());

	        return livreAdd;
	    }
	    
	    public static LivreEntity modifLivre(LivreRequestSaveDTO reqModifLivre, LivreEntity livreModif) {
	        
	    	livreModif.setDateParution(reqModifLivre.getDateParution());
	    	livreModif.setEditeur(reqModifLivre.getEditeur());
	    	livreModif.setGenre(reqModifLivre.getGenre());
	    	livreModif.setNom(reqModifLivre.getNom());
	    	livreModif.setLieuParution(reqModifLivre.getLieuParution());
	    	livreModif.setNbPages(reqModifLivre.getNbPages());
	    	livreModif.setAuteur(reqModifLivre.getAuteur());
	    	
	        return livreModif;


	    }
}

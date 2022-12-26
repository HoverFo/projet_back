package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.ChartDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.dto.IndicateurDTO;
import com.univlittoral.projetback.dto.LivreDTO;
import com.univlittoral.projetback.dto.LivreRequestSaveDTO;
import com.univlittoral.projetback.dto.TypeDTO;
import com.univlittoral.projetback.dto.TypeEnum;
import com.univlittoral.projetback.entity.LivreEntity;
import com.univlittoral.projetback.mapper.AuteurMapper;
import com.univlittoral.projetback.mapper.LivreMapper;
import com.univlittoral.projetback.service.LivreService;




@RestController //-> est utilisé pour marquer les classes en tant que contrôleur Spring.
@RequestMapping(value = "/rest/bd/") //=> l’URL d’accès à votre controller.
public class HomeController {
	
    @Autowired
    private LivreService service;
    
    @GetMapping(value ="/home")
   
    public HomeDTO getHome(){
    	
        HomeDTO home = new HomeDTO();
        final TypeDTO ListGenre = new TypeDTO();
        final List<LivreEntity> entities = service.findAllLivres();

        List listeGenre = new ArrayList();
        
        ChartDTO pieChart = new ChartDTO();
        
      //Création de List qui contiennent les couleurs, labels, values
    	List<String> colors = new ArrayList<String>(); 
        List<String> labels = new ArrayList<String>(); 
        List<Integer> values = new ArrayList<Integer>(); 
        
        
        //Indicateurs
        IndicateurDTO indicateur = new IndicateurDTO();
        indicateur.setNbLivres(service.findAllLivres().size());
        indicateur.setNbAuteurs(service.findAllAuteurs().size());
       
        for(final LivreEntity entity : service.findAllLivres()) {
            if(!listeGenre.contains(entity.getGenre())) {
            	listeGenre.add(entity.getGenre());
            }
        }
        
        indicateur.setNbGenres(listeGenre.size());
        
        // Listes des genres avec une hashmap
    	final Map<String, Integer> tabListeGenre = new HashMap();
    	//On parcours les livres et on récupère le genre de chacun
    	for (int i = 0; i < entities.size(); i++){
    		LivreEntity livre = entities.get(i);
    		String genre =  livre.getGenre().toString();
    		boolean existe = tabListeGenre.containsKey(genre);
    		
    		//Si c'est un nouveaux genre ont l'ajoute dans le tableau
    		if(!existe) {
    	    	tabListeGenre.put(genre, 1);
    	    // Si le genre existe déjà dans le tableau ont ajoute +1
    		}else{
    	    	tabListeGenre.put(genre, tabListeGenre.get(genre) + 1);
    	    }
    	}

    	
    	ListGenre.setListeGenre(tabListeGenre);
    	
    	
    	//PieChart
        ArrayList<Integer> graphGenreNb = new ArrayList<Integer>();
        ArrayList<String> graphLabels = new ArrayList<String>();

        graphGenreNb = service.findNbGenre();
        graphLabels = service.findGenre();
        
        for (int i = 0; i < graphLabels.size(); i++){
        	  labels.add(graphLabels.get(i));
        	  values.add(graphGenreNb.get(i));
        	}
    	
        colors.add("#F299EC");
        colors.add("#A75CF2");
        colors.add("#E3D8F2");
        colors.add("#05C7F2");
        colors.add("#F2E205");

        pieChart.setCouleur(colors);
        pieChart.setLabels(labels);
        pieChart.setValeur(values);
        
        home.setDatasGraph(pieChart);
    	
    	//set des différents livres, genres et indicateurs pour le home
    	home.setLivres(LivreMapper.map(service.findAllLivres()));
    	home.setGenres(tabListeGenre);
        home.setIndicateurs(indicateur);
        
        
        
        return home;
    }
    
    //Retrouver un livre avec son id
    @GetMapping("/livres/{id}")

    public LivreDTO findById(@PathVariable Integer id) {
        return LivreMapper.map(service.findLivreById(id));
    }
    
    //Supprimer un livre
    @DeleteMapping("/livres/{id}")

    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
    
    //Ajout d'un livre
    @PostMapping("/livres")
   
    public void save(@RequestBody LivreRequestSaveDTO reqAddLivre) {
        LivreEntity livre = LivreMapper.addLivre(reqAddLivre);
        service.saveOrUpdateLivre(livre);
    }
    
    //Modification d'un livre
    @PutMapping("/livres/{id}")
    public void modif(@PathVariable Integer id, @RequestBody LivreRequestSaveDTO reqModifLivre) {
        service.saveOrUpdateLivre(LivreMapper.modifLivre(reqModifLivre, service.findLivreById(id)));
    }
    
    //Trouver les livres du genre
    @GetMapping("livres")
   
	public List<LivreDTO> findByGenre(@RequestParam TypeEnum genre){
		return LivreMapper.map(service.findByGenre(genre));
	}
    
    
    
  //Retrouver un auteur avec son id
    @GetMapping("/auteurs/{id}")
    
    public AuteurDTO findAuteurById(@PathVariable Integer id) {
        return AuteurMapper.map(service.findAuteurById(id));
    }
    
	//Obtenir les auteurs
	@GetMapping("/auteurs")

	public List<AuteurDTO> findAllAuteurs(){
		return AuteurMapper.map(service.findAllAuteurs());
	}

	        
}
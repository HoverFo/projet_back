package com.univlittoral.projetback.dto;

import java.util.Map;

public class TypeDTO {

	private Map<String,Integer> listeTypes;

	public Map<String, Integer> getListeGenre() {
		return listeTypes;
	}

	public void setListeGenre(Map<String, Integer> listeTypes) {
		this.listeTypes = listeTypes;
	}
}

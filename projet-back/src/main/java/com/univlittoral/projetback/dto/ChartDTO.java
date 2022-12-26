package com.univlittoral.projetback.dto;

import java.util.List;

public class ChartDTO {

	private List<String> couleur;
	private List<String> labels;
	private List<Integer> valeur;

	public List<String> getCouleur() {
		return couleur;
	}

	public void setCouleur(List<String> couleur) {
		this.couleur = couleur;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<Integer> getValeur() {
		return valeur;
	}

	public void setValeur(List<Integer> valeur) {
		this.valeur = valeur;
	}

	
}

package com.univlittoral.projetback.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.univlittoral.projetback.dto.TypeEnum;


@Entity // => Pour que votre application Spring boot sache que cette classe est une entité
@Table(name="livres") //=> le nom de la table de votre base de données associée à cet objet Entité.
public class LivreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="editeur")
	private String editeur;
	
	@Column(name="nb_pages")
	private Integer nbPages;
	
	@Column(name="date_parution")
	private Date dateParution;
	
	@Column(name="lieu_parution")
	private String lieuParution;
	
	
	@Column(name="genre")
	@Enumerated(EnumType.STRING)
	private TypeEnum genre;
	
	@ManyToOne()
    @JoinColumn(name="auteur", referencedColumnName = "id")    
    private AuteurEntity auteur;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public String getLieuParution() {
		return lieuParution;
	}

	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}

	

	public TypeEnum getGenre() {
		return genre;
	}

	public void setGenre(TypeEnum genre) {
		this.genre = genre;
	}

	public AuteurEntity getAuteur() {
		return auteur;
	}

	public void setAuteur(AuteurEntity auteur) {
		this.auteur = auteur;
	}
	
	
	
	
	
	
}

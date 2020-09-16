package sn.demandeur.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Offre implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=100)
	private String nomOffre;
	@Column(length=100)
	private String type;
	@ManyToOne
	private Entreprise entreprise = new Entreprise();
	@ManyToOne
	private Categorie categorie = new Categorie();
	@OneToMany(mappedBy="offre")
	private List<CvDemandeur> cvDemandeur = new ArrayList<CvDemandeur>();
	
	public Offre() {
		super();
	}
	

	public Offre(int id, String nomOffre, String type, Entreprise entreprise, Categorie categorie,
			List<CvDemandeur> cvDemandeur) {
		super();
		this.id = id;
		this.nomOffre = nomOffre;
		this.type = type;
		this.entreprise = entreprise;
		this.categorie = categorie;
		this.cvDemandeur = cvDemandeur;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomOffre() {
		return nomOffre;
	}

	public void setNomOffre(String nomOffre) {
		this.nomOffre = nomOffre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<CvDemandeur> getCvDemandeur() {
		return cvDemandeur;
	}


	public void setCvDemandeur(List<CvDemandeur> cvDemandeur) {
		this.cvDemandeur = cvDemandeur;
	}
	
	
}

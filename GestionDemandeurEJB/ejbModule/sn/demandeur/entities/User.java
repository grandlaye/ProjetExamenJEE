package sn.demandeur.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=200)
	private String nom;
	@Column(length=200)
	private String prenom;
	@Column(length=100)
	private String email;
	@Column(length=100)
	private String password;
	@ManyToMany
	private List<Demandeur> demandeurs = new ArrayList<Demandeur>();
	@ManyToMany
	private List<Entreprise> entreprises = new ArrayList<Entreprise>();
	
	
	public User() {
		super();
	}


	public User(int id, String nom, String prenom, String email, String password, List<Demandeur> demandeurs,
			List<Entreprise> entreprises) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.demandeurs = demandeurs;
		this.entreprises = entreprises;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Demandeur> getDemandeurs() {
		return demandeurs;
	}


	public void setDemandeurs(List<Demandeur> demandeurs) {
		this.demandeurs = demandeurs;
	}


	public List<Entreprise> getEntreprises() {
		return entreprises;
	}


	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	
	
}

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
public class Entreprise implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=100)
	private String nomEse;
	@Column(length=100)
	private String lieu;
	@Column(length=100)
	private String codeNinea;
	@Column(length=100)
	private String email;
	@Column(length=50)
	private String password;
	@OneToMany(mappedBy="entreprise")
	private List<Offre> offre = new ArrayList<Offre>();
	@OneToMany(mappedBy="entreprise")
	private List<CvDemandeur> cvDemandeur = new ArrayList<CvDemandeur>();
	@ManyToMany
	private List<User> user = new ArrayList<User>();
	
	public Entreprise() {
		super();
	}

	

	public Entreprise(int id, String nomEse, String lieu, String codeNinea, String email, String password,
			List<Offre> offre, List<CvDemandeur> cvDemandeur, List<User> users) {
		super();
		this.id = id;
		this.nomEse = nomEse;
		this.lieu = lieu;
		this.codeNinea = codeNinea;
		this.email = email;
		this.password = password;
		this.offre = offre;
		this.cvDemandeur = cvDemandeur;
		this.user = users;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEse() {
		return nomEse;
	}

	public void setNomEse(String nomEse) {
		this.nomEse = nomEse;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getCodeNinea() {
		return codeNinea;
	}

	public void setCodeNinea(String codeNinea) {
		this.codeNinea = codeNinea;
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

	public List<Offre> getOffre() {
		return offre;
	}

	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}

	public List<CvDemandeur> getCvDemandeur() {
		return cvDemandeur;
	}

	public void setCvDemandeur(List<CvDemandeur> cvDemandeur) {
		this.cvDemandeur = cvDemandeur;
	}



	public List<User> getUser() {
		return user;
	} 



	public void setUser(List<User> user) {
		this.user = user;
	}

	
	
	
}

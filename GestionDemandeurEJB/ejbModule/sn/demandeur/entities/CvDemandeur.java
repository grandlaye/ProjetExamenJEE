package sn.demandeur.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CvDemandeur implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=100)
	private String nomCV;
	@Column(length=100)
	private String prenomCV;
	@Column(length=100)
	private String emailCV;
	@Column(length=50)
	private String addresse;
	@Column(length=200)
	private String specialite;
	@Column(length=50)
	private String tel;
	@Column(length=200)
	private String niveau;
	@Column(length=200)
	private String experience;
	@ManyToOne
	private Entreprise entreprise = new Entreprise();
	@ManyToOne
	private Offre offre = new Offre();
	
	public CvDemandeur() {
		super();
	}
	
		
	public CvDemandeur(int id, String nomCV, String prenomCV, String emailCV, String addresse, String specialite,
			String tel, String niveau, String experience, Entreprise entreprise, Offre offre) {
		super();
		this.id = id;
		this.nomCV = nomCV;
		this.prenomCV = prenomCV;
		this.emailCV = emailCV;
		this.addresse = addresse;
		this.specialite = specialite;
		this.tel = tel;
		this.niveau = niveau;
		this.experience = experience;
		this.entreprise = entreprise;
		this.offre = offre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomCV() {
		return nomCV;
	}


	public void setNomCV(String nomCV) {
		this.nomCV = nomCV;
	}


	public String getPrenomCV() {
		return prenomCV;
	}


	public void setPrenomCV(String prenomCV) {
		this.prenomCV = prenomCV;
	}


	public String getEmailCV() {
		return emailCV;
	}


	public void setEmailCV(String emailCV) {
		this.emailCV = emailCV;
	}


	public String getAddresse() {
		return addresse;
	}


	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public Offre getOffre() {
		return offre;
	}


	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	
}

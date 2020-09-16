package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.Demandeur;
import sn.demandeur.entities.Entreprise;

@Local
public interface IDemandeur {

	public Demandeur getLogin(String email, String password);
	
	public int add(Demandeur demandeur);
	public int update(Demandeur demandeur);
	public int delete(int id);
	public List<Demandeur> getAll();
	public Demandeur get(int id);
}

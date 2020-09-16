package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.Entreprise;
import sn.demandeur.entities.User;

@Local
public interface IEntreprise {

	public Entreprise getLogin(String email, String password);
	
	public int add(Entreprise entreprise);
	public int update(Entreprise entreprise);
	public int delete(int id);
	public List<Entreprise> getAll();
	public Entreprise get(int id);
}

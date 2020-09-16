package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.Categorie;


@Local
public interface ICategorie {

	public int add(Categorie categorie);
	public int update(Categorie categorie);
	public int delete(int id);
	public List<Categorie> getAll();
	public Categorie get(int id);
}

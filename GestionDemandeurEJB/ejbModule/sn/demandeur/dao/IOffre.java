package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.Offre;

@Local
public interface IOffre {

	public int add(Offre offre);
	public int update(Offre offre);
	public int delete(int id);
	public List<Offre> getAll();
	public Offre get(int id);
}

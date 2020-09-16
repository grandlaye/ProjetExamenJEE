package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.CvDemandeur;


@Local
public interface ICvDemandeur {

	public int add(CvDemandeur cvDemandeur);
	public int update(CvDemandeur cvDemandeur);
	public List<CvDemandeur> getAll();
	public CvDemandeur get(int id);
}

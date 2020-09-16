package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.demandeur.entities.CvDemandeur;
import sn.demandeur.entities.User;

@Stateless
public class CvDemandeurImpl implements ICvDemandeur{

	@PersistenceContext(unitName="GestionDemandeur")
	private EntityManager em;
	
	@Override
	public int add(CvDemandeur cvDemandeur) {
		try {
			em.persist(cvDemandeur);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(CvDemandeur cvDemandeur) {
		try {
			em.merge(cvDemandeur);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<CvDemandeur> getAll() {
		try {
			return em.createQuery("SELECT c FROM CvDemandeur c").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public CvDemandeur get(int id) {
		return em.find(CvDemandeur.class, id);
	}

}

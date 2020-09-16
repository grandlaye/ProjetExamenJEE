package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.demandeur.entities.Offre;
import sn.demandeur.entities.User;

@Stateless
public class OffreImpl implements IOffre{

	@PersistenceContext(unitName="GestionDemandeur")
	private EntityManager em;
	
	@Override
	public int add(Offre offre) {
		try {
			em.persist(offre);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Offre offre) {
		try {
			em.merge(offre);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(id);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Offre> getAll() {
		try {
			return em.createQuery("SELECT o FROM Offre o").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Offre get(int id) {
		return em.find(Offre.class, id);
	}

}

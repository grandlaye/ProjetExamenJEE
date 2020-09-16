package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.demandeur.entities.Categorie;
import sn.demandeur.entities.User;

@Stateless
public class CategorieImpl implements ICategorie{

	@PersistenceContext(unitName="GestionDemandeur")
	private EntityManager em;
	
	@Override
	public int add(Categorie categorie) {
		try {
			em.persist(categorie);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Categorie categorie) {
		try {
			em.merge(categorie);
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
	public List<Categorie> getAll() {
		try {
			return em.createQuery("SELECT c FROM Categorie c").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Categorie get(int id) {
		return em.find(Categorie.class, id);
	}

}

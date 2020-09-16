package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.demandeur.entities.Entreprise;
import sn.demandeur.entities.User;

@Stateless
public class EntrepriseImpl implements IEntreprise{

	@PersistenceContext(unitName="GestionDemandeur")
	private EntityManager em;
	
	@Override
	public int add(Entreprise entreprise) {
		try {
			em.persist(entreprise);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Entreprise entreprise) {
		try {
			em.merge(entreprise);
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
	public List<Entreprise> getAll() {
		try {
			return em.createQuery("SELECT c FROM Entreprise c").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Entreprise get(int id) {
		return em.find(Entreprise.class, id);
	}

	@Override
	public Entreprise getLogin(String email, String password) {
		try {
			return (Entreprise)em.createQuery("SELECT u FROM Entreprise u WHERE u.email = :em AND u.password = :pwd")
					.setParameter("em", email)
					.setParameter("pwd", password)
					.getSingleResult();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.demandeur.entities.User;

@Stateless
public class UserImpl implements IUser{

	@PersistenceContext(unitName="GestionDemandeur")
	private EntityManager em;
	
	@Override
	public User getLogin(String email, String password) {
		try {
			return (User)em.createQuery("SELECT u FROM User u WHERE u.email = :em AND u.password = :pwd")
					.setParameter("em", email)
					.setParameter("pwd", password)
					.getSingleResult();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public int add(User users) {
		try {
			em.persist(users);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(User usres) {
		try {
			em.merge(usres);
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
	public List<User> getAll() {
		try {
			return em.createQuery("SELECT u FROM User u").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public User get(int id) {
		return em.find(User.class, id);
	}
	
}

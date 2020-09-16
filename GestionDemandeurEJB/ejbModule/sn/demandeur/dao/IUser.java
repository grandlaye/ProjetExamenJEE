package sn.demandeur.dao;

import java.util.List;

import javax.ejb.Local;

import sn.demandeur.entities.User;

@Local
public interface IUser {

	public User getLogin(String email, String password);
	
	public int add(User users);
	public int update(User usres);
	public int delete(int id);
	public List<User> getAll();
	public User get(int id);
}

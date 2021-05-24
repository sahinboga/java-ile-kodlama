package eTicaretOdev.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List<User> users=new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println("Kayýt olundu: " + user.getFirstName() + " " + user.getLastName());
		users.add(user);
		
	}

	@Override
	public void login(User user) {
		System.out.println("Giriþ yapýldý: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}
	
	


}

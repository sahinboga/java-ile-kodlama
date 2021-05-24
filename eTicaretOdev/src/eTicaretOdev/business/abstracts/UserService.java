package eTicaretOdev.business.abstracts;

import java.util.List;

import eTicaretOdev.entities.concretes.User;

public interface UserService {
	User login(String ePosta, String password);
	void register(User user);
	List<User> getAll();
	void RegisterWithService();
}

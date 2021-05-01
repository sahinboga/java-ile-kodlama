package oop_odev2;

public class UserManager {
	public void add(User user) {
		System.out.println(user.firstName+" "+user.lastName+" kaydedildi");
		
	}
	
	public void delete(User user) {
		System.out.println(user.firstName+" "+user.lastName+" silindi");
	}
	
	public void addMultiple(User[] users) {
		for(User user: users) {
			add(user);
		}
	}
	
	public void deleteMultiple(User[] users) {
		for(User user: users) {
			delete(user);
		}
	}
}

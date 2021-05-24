package eTicaretOdev.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.core.BaseService;
import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private BaseService baseService;
	
	public UserManager(UserDao userDao, BaseService baseService) {
		super();
		this.userDao = userDao;
		this.baseService=baseService;
	}

	@Override
	public User login(String ePosta, String password) {
		for(User user:userDao.getAll()) {
			if(user.getePosta().toLowerCase().equals(ePosta) && user.getPassword().equals(password)) {
				userDao.login(user);
				return user;
			}
		}
		System.out.println("e-posta veya þifreniz hatalý!");
		return null;
	}

	@Override
	public void register(User user) {
		
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ad ve Soyad en az 2 karakterden oluþmalýdýr!");
			return;
		}
		
		if(user.getPassword().length()<=6) {
			System.out.println("Þifre en az 6 karakter olmalýdýr!");
			return;
		}
		
		///////////////////////////////////////////////////////////
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getePosta());
		if(!matcher.matches()) {
			System.out.println("Mail adresi Yanlýþ");
			return;
		}
		for(User member : userDao.getAll()) {
			if(member.getePosta().toLowerCase().contains(user.getePosta().toLowerCase())) {
				System.out.println("Mail adresi mevcut: " + member.getePosta());
				return;
			}
		}
		
		sendValidePosta();
		validateEposta();
		userDao.register(user);
		
	}
	
	public void sendValidePosta() {
		System.out.println("e-posta gönderildi");
	}
	
	public void validateEposta() {
		System.out.println("e-posta doðrulandý");
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public void RegisterWithService() {
		baseService.registerWithService();
		
	}

	

}

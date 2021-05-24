package eTicaretOdev;

import java.util.Scanner;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.business.concretes.UserManager;
import eTicaretOdev.core.GoogleServiceAdapters;
import eTicaretOdev.dataAccess.concretes.HibernateUserDao;
import eTicaretOdev.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService= new UserManager(new HibernateUserDao(),new GoogleServiceAdapters());
		userService.register(new User(1,"�ahin","Bo�a","sahin0000","abc@gmail.com"));
		userService.register(new User(1,"Yasin","Torun","torun80","torun@gmail.com"));
		userService.register(new User(1,"Yasin","Torun","torun80","torun@gmail.com"));
		userService.register(new User(1,"A","B","torun80","torun@gmail.com"));
		userService.register(new User(1,"�ahin","Bo�a","sah","ceza@gmail.com"));
		userService.register(new User(1,"�ahin","Bo�a","sahin0000","abc#gmail,com"));
		userService.RegisterWithService();
		Scanner scanner=new Scanner(System.in);
		
		User user;
		
		do {
			
			user=new User();
			System.out.println("e-posta:");
			String ePosta=scanner.next();
			System.out.println("�ifre:");
			String password=scanner.next();
			
			user=userService.login(ePosta, password);
			
		}while(user==null);
		
		scanner.close();
	}

}

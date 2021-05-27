package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserRegisterService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	private UserRegisterManager userRegisterManager;
	
	
	@Autowired
	public UserManager(UserDao userDao, UserRegisterManager userRegisterManager) {
		super();
		this.userDao = userDao;
		this.userRegisterManager= userRegisterManager;
	}
	@Override
	public DataResult<List<User>> getAll() {
		return new  SuccessDataResult<List<User>>(this.userDao.findAll(), "Data Listelendi");
		
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		userRegisterManager.newRegister(user);
		return new SuccessDataResult<User>(user,"Kullanıcı eklendi");
	}
	
	

}

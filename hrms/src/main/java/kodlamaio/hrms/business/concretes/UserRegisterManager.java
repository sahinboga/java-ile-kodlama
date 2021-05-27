package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserRegisterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserRegisterDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserRegister;

@Service
public class UserRegisterManager implements UserRegisterService {

	UserRegisterDao userRegisterDao;
	
	@Autowired
	public UserRegisterManager(UserRegisterDao userRegisterDao) {
		super();
		this.userRegisterDao = userRegisterDao;
	}

	@Override
	public DataResult<List<UserRegister>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(UserRegister userRegister) {
		this.userRegisterDao.save(userRegister);
		return new SuccessResult("Kayıt Oluşturuldu");
	}
	
	public Result newRegister(User user) {
		
		Random rand=new Random();
		
		String code=String.format("%04d",1000+rand.nextInt(9000));
		
		UserRegister userRegister=new UserRegister();
		userRegister.setUserId(user.getUserId());
		userRegister.set_comfirmed(false);
		userRegister.setActivision_code(code);
		userRegister.setRegister_date(new Date());
		
		return this.add(userRegister);
	}

}

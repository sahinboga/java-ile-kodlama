package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.helpers.CheckHelper;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private UserManager userManager;
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserManager userManager) {
		super();
		this.employerDao = employerDao;
		this.userManager= userManager;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}
	
	@Override
	public Result add(Employer employer) {
		
		if(isNull(employer)) {
			return new ErrorResult("Tüm alanlar zorunludur!");
		}
		
		if(!CheckHelper.EmailCheck(employer.getEposta())) {
			
			return new ErrorResult("Eposta hatalı!");
		}
		
		String domain= employer.getEposta().split("@")[1];
		
		// Burayı düzenlemeyi unutmaaaaaaaaaaaaa!!!!!!!!!!
		if(!domain.startsWith(employer.getCompany_name())) {
			return new ErrorResult("Lütfen şirket adınıza kayıtlı eposta kullanınız");
		}
		
		if(isExist(employer)) {
			
			return new ErrorResult("Eposta daha önce kayıtlıdır!");
		}
		
		DataResult<User> result= (DataResult<User>) userManager.add((User)employer);
		
		if(result.isSuccess()) {
			
			employer.setUserId(result.getData().getUserId());
			this.employerDao.save(employer);
			
			return new SuccessResult("İşveren eklendi");
		}
		
		return new ErrorResult("Kayıt Başarısız!");
		
		
	}
	
	public boolean isNull(Employer employer) {
		
		return employer.getEposta().isEmpty() || employer.getPassword().isEmpty() || 
				
				employer.getCompany_name().isEmpty() || employer.getPhone().isEmpty();
	}
	
	public boolean isExist(Employer employer) {
		
		return employerDao.existsUserByEposta(employer.getEposta());
	}
	
	

}

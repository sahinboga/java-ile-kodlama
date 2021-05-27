package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.helpers.CheckHelper;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.service.Mernis;
@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private UserManager userManager;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserManager userManager) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userManager= userManager;
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(isNull(jobSeeker)) {
			
			return new ErrorResult("Tüm alanlar zorunludur!");
		}
		
		DataResult<JobSeeker> result=Mernis.validate(jobSeeker);
		if(!result.isSuccess()) {
			return result;
		}
		
		if(!CheckHelper.EmailCheck(jobSeeker.getEposta())) {
			
			return new ErrorResult("Eposta hatalı!");
		}
		
		if(isExist(jobSeeker)) {
			return new ErrorResult("Eposta veya TcNo daha önceden Kayıtlıdır!");
		}
		
		DataResult<User> userResult= (DataResult<User>) userManager.add((User)jobSeeker);
		
		if(userResult.isSuccess()) {
			
			jobSeeker.setUserId(userResult.getData().getUserId());
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İş arayan eklendi");
		}
		
		return new ErrorResult("Kayıt başarısız!");		
		
	}
	
	public boolean isNull(JobSeeker jobseeker) {
		
		return jobseeker.getEposta().isEmpty() || jobseeker.getFirstname().isEmpty() || jobseeker.getLastname().isEmpty() ||
				 jobseeker.getPassword().isEmpty() || jobseeker.getTcNo().isEmpty();
	}
	
	public boolean isExist(JobSeeker jobSeeker) {
		
		return jobSeekerDao.existsJobseekerByTcNo(jobSeeker.getTcNo()) || jobSeekerDao.existsUserByEposta(jobSeeker.getEposta());
	}

}

package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data Listelendi");
				
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(isExist(jobPosition)) {
			
			return new ErrorResult("İş pozisyonu zaten mevcuttur!");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi");
	}
	
	public boolean isExist(JobPosition jobPosition) {
		
		return jobPositionDao.existsJobPositionByJobName(jobPosition.getJobName());
	}

}

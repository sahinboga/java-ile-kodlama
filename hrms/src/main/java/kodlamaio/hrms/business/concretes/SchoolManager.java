package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"okul listlendi");
	}

	@Override
	public Result add(School entity) {
		// TODO Auto-generated method stub
		this.schoolDao.save(entity);
		
		return new SuccessResult("Okul eklendi");
	}

}

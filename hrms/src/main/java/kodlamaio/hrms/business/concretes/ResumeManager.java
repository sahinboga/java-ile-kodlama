package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.convertes.ResumeDtoConverter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDisplayDto;
import kodlamaio.hrms.entities.dtos.ResumeForNewDto;

@Service
public class ResumeManager implements ResumeService {
	
	private ResumeDao resumeDao;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"CV listelendi");
	}

	@Override
	public Result add(Resume entity) {
		this.resumeDao.save(entity);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public Result add(ResumeForNewDto resume) {
		this.resumeDao.save(ResumeDtoConverter.InputToNormalDto(resume));
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<ResumeDisplayDto>> getAllDisplay() {
		
		return new SuccessDataResult<List<ResumeDisplayDto>>
		(ResumeDtoConverter.NormalToDisplayDto(this.resumeDao.findAll()),"CV eklendi");
	}

}

package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.convertes.SkillDtoConverter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDisplayDto;

@ Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"Yetenek Listelendi");
	}

	@Override
	public Result add(Skill entity) {
		this.skillDao.save(entity);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<List<SkillDisplayDto>> getAllDisplay() {
		return new SuccessDataResult<List<SkillDisplayDto>>(SkillDtoConverter.NormalToDisplayDto(this.skillDao.findAll()),"Yetenek listelendi");
	}

}

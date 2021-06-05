package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.convertes.EducationDtoconverter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDisplayDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Eğitim listelendi");
	}

	@Override
	public Result add(Education entity) {
		this.educationDao.save(entity);
		return new SuccessResult("Eğitim Eklendi");
	}

	@Override
	public DataResult<List<EducationDisplayDto>> getAllDisplay() {

		return new SuccessDataResult<List<EducationDisplayDto>>
		(EducationDtoconverter.NormalToDisplayDto(this.educationDao.findAll()),"Eğitim listelendi");
	}

	@Override
	public DataResult<List<EducationDisplayDto>> getAllSorted() {
		Sort sorted= Sort.by(Sort.Direction.DESC,"graduationDate");
		return new SuccessDataResult<List<EducationDisplayDto>>
		(EducationDtoconverter.NormalToDisplayDto(this.educationDao.findAll(sorted)), "Mezuniyet Tarihleri tersten sıralandı");
	}

}

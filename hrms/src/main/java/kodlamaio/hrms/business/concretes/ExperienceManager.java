package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.convertes.ExperienceDtoconverter;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDisplayDto;

@Service
public class ExperienceManager implements ExperienceService {
	

		private ExperienceDao experienceDao;
		
		@Autowired
		public ExperienceManager(ExperienceDao experienceDao) {
			super();
			this.experienceDao = experienceDao;
		}
		@Override
		public DataResult<List<Experience>> getAll() {
			
			return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"İş Deneyimi listelendi");
		}
	
		@Override
		public Result add(Experience entity) {
			this.experienceDao.save(entity);
			return new SuccessResult("İş Deneyimi eklendi");
		}
		@Override
		public DataResult<List<ExperienceDisplayDto>> getAllDisplay() {
			return new SuccessDataResult<List<ExperienceDisplayDto>>
			(ExperienceDtoconverter.NormalToDisplayDto(this.experienceDao.findAll()),"İş Deneyimi listelendi");
		}
		@Override
		public DataResult<List<ExperienceDisplayDto>> getAllSorted() {
			Sort sorted= Sort.by(Sort.Direction.DESC,"leaveDate");
			return new SuccessDataResult<List<ExperienceDisplayDto>>
			(ExperienceDtoconverter.NormalToDisplayDto(this.experienceDao.findAll(sorted)),"Deneyimler tersten sıralandı");
		}

}

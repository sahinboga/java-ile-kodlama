package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.DisplayJobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"iş ilanı eklendi");
	}

	@Override
	public Result add(JobAdvertisement entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		
		JobAdvertisement jobAdvertisement= new JobAdvertisement(jobAdvertisementDto.getDescription(),jobAdvertisementDto.getCity(),jobAdvertisementDto.getMinSalary(),jobAdvertisementDto.getMaxSalary(),jobAdvertisementDto.getMaxPerson(),
				new Date(),jobAdvertisementDto.getDeadline(),false,jobAdvertisementDto.getJobPositionId(),jobAdvertisementDto.getEmployerId());
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi") ;
	}

	@Override
	public DataResult<List<DisplayJobAdvertisementDto>> getByIsActive(boolean isActive) {
		List<DisplayJobAdvertisementDto> displayJobAdvertisementDto=new ArrayList<DisplayJobAdvertisementDto>();
		
		List<JobAdvertisement> activeList= this.jobAdvertisementDao.getByIsActive(isActive);
		
		for(int i=0;i<activeList.size();i++) {
			
			displayJobAdvertisementDto.add(new DisplayJobAdvertisementDto(
					activeList.get(i).getEmployer().getCompany_name(),activeList.get(i).getJobPosition().getJobName(),
					activeList.get(i).getMaxPerson(),activeList.get(i).getReleaseDate(),activeList.get(i).getDeadline()
					));
			
		}
		return new SuccessDataResult<List<DisplayJobAdvertisementDto>>(displayJobAdvertisementDto,"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<DisplayJobAdvertisementDto>> getByIsActiveAndReleaseDate(boolean isActive, Date releaseDate) {
		List<DisplayJobAdvertisementDto> displayJobAdvertisementDto=new ArrayList<DisplayJobAdvertisementDto>();
		
		List<JobAdvertisement> activeList= this.jobAdvertisementDao.getByIsActiveAndReleaseDate(isActive, releaseDate);
		
		for(int i=0;i<activeList.size();i++) {
			
			displayJobAdvertisementDto.add(new DisplayJobAdvertisementDto(
					activeList.get(i).getEmployer().getCompany_name(),activeList.get(i).getJobPosition().getJobName(),
					activeList.get(i).getMaxPerson(),activeList.get(i).getReleaseDate(),activeList.get(i).getDeadline()
					));
			
		}
		return new SuccessDataResult<List<DisplayJobAdvertisementDto>>(displayJobAdvertisementDto,"Aktif iş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"releaseDate");
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(NormalToDto(this.jobAdvertisementDao.findAll(sort)),"Başarılı");
	

	}
	private List<JobAdvertisementDto> NormalToDto(List<JobAdvertisement> normalList) {
		List<JobAdvertisementDto> dtoList = new ArrayList<JobAdvertisementDto>();
		
		for(int i=0;i< normalList.size();++i) {
			
			JobAdvertisement current=normalList.get(i);
			dtoList.add(new JobAdvertisementDto(
					
					current.getDefinition(),
					current.getMinSalary(),
					current.getMaxSalary(),
					current.getMaxPerson(),
					current.getDeadline(),
					current.isActive(),
					current.getCity(),
					current.getJobPosition().getId(),
					current.getEmployer().getUserId()
					
			));
			
		}
		
		return dtoList;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_UserId(boolean isActive, int userId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_UserId(isActive,userId),"Listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> getUpdate(int jobAdvertisementId) {
		
		JobAdvertisement current = jobAdvertisementDao.getOne(jobAdvertisementId);
		current.setActive(false);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(current),"İlan Pasif hale getirildi");
	}
}
	
	

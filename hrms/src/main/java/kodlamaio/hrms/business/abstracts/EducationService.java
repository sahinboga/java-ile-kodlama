package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDisplayDto;

public interface EducationService extends BaseService<Education> {
	
	public DataResult<List<EducationDisplayDto>> getAllDisplay();
	
	public DataResult<List<EducationDisplayDto>> getAllSorted();
}

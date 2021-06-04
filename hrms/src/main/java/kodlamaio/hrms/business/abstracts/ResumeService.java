package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDisplayDto;
import kodlamaio.hrms.entities.dtos.ResumeForNewDto;

public interface ResumeService extends BaseService<Resume> {
	
	public Result add(ResumeForNewDto resume);
	
	public DataResult<List<ResumeDisplayDto>> getAllDisplay();
}

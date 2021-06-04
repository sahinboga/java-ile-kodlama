package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	
	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"Bölüm listelendi");
	}

	@Override
	public Result add(Department entity) {

		this.departmentDao.save(entity);
		return new SuccessResult("Bölüm eklendi");
	}

}

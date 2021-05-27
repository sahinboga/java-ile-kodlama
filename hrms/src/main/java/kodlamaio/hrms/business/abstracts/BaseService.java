package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

public interface BaseService<T> {
	public DataResult<List<T>> getAll();
	
	public Result add(T entity);
}

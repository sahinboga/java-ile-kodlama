package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonel;
@Service
public class SystemPersonelManager implements SystemPersonelService {
	
	private SystemPersonelDao systemPersonelDao;
	
	@Autowired
	public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
		super();
		this.systemPersonelDao = systemPersonelDao;
	}
	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(), "Data Listelendi");
	}
	@Override
	public Result add(SystemPersonel systemPersonel) {
		this.systemPersonelDao.save(systemPersonel);
		return new SuccessResult("Personel eklendi");
	}

}

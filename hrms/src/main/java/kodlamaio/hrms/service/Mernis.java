package kodlamaio.hrms.service;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public class Mernis {
	public static DataResult<JobSeeker> validate(JobSeeker jobSeeker) {
		if (jobSeeker.getTcNo().length()!=11) {
			return new ErrorDataResult<JobSeeker>("Tc No hatalı!");
		}
		
		return new SuccessDataResult<JobSeeker>("Doğrulama tamamlandı");
	}
}

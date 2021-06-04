package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	boolean existsJobseekerByTcNo(String tc_no);
	boolean existsUserByEposta(String eposta);
}

package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.DisplayJobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAllAdvertisement")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@GetMapping("/getActiveAdvertisement")
	public DataResult<List<DisplayJobAdvertisementDto>>  getByIsActive(){
		return this.jobAdvertisementService.getByIsActive(true);
		
	}
	
	@GetMapping("/getActiveAdvertisementDate")
	public DataResult<List<DisplayJobAdvertisementDto>>  getByIsActiveAndReleaseDate(@RequestParam Date relaseDate){
		
		return this.jobAdvertisementService.getByIsActiveAndReleaseDate(true, null);
	}
	
	@GetMapping("/getAllSortedAdvertisement")
	public DataResult<List<JobAdvertisementDto>> getAllSorted(){
		return this.jobAdvertisementService.getAllSorted();
	}
	
	@GetMapping("/getAllCompanyNameAdvertisement")
	public DataResult<List<JobAdvertisement>>getByIsActiveAndEmployer_UserId(boolean isActive, int userId){
		
		return this.jobAdvertisementService.getByIsActiveAndEmployer_UserId(isActive, userId);
	}
	
	@GetMapping("/getUpdate")
	public DataResult<JobAdvertisement> getUpdate(int jobAdvertisementId){
		return this.jobAdvertisementService.getUpdate(jobAdvertisementId);
	}

}

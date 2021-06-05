package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDisplayDto;

@RequestMapping
@RestController("/api/educations")
public class EducationController {
	
	private EducationService educationService;
	
	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAllEducation")
	public DataResult<List<EducationDisplayDto>> getAll(){
		
		return this.educationService.getAllDisplay();
	}
	
	@PostMapping("/addEducations")
	public Result add(@RequestBody Education education) {
		
		return this.educationService.add(education);
	}
	
	@GetMapping("/getAllSortEducation")
	public DataResult<List<EducationDisplayDto>> getAllSorted(){
		
		return this.educationService.getAllSorted();
	}
}

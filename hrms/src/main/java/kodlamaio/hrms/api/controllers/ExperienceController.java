package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDisplayDto;

@RequestMapping
@RestController("/api/experiences")
public class ExperienceController {
	
	private ExperienceService experienceService;
	
	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAllExperince")
	public DataResult<List<ExperienceDisplayDto>> getAll(){
		
		return this.experienceService.getAllDisplay();
	}
	
	@PostMapping("/addExperince")
	public Result add(@RequestBody Experience experience) {
		
		return this.experienceService.add(experience);
	}
	
	@GetMapping("/getAllSortExperince")
	public DataResult<List<ExperienceDisplayDto>> getAllSorted(){
		
		return this.experienceService.getAllSorted();
	}
}

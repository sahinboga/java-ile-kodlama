package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDisplayDto;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
	
	private SkillService skillService;
	
	@Autowired
	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	};
	
	@GetMapping("/getAllSkill")
	public DataResult<List<SkillDisplayDto>> getAll() {
		return this.skillService.getAllDisplay();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
}

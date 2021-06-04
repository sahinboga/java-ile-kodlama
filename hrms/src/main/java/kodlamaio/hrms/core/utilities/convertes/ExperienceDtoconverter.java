package kodlamaio.hrms.core.utilities.convertes;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDisplayDto;

public class ExperienceDtoconverter {
	
	public static ExperienceDisplayDto NormalToDisplayDto(Experience exc) {
		
		return new ExperienceDisplayDto(exc.getCompanyName(),exc.getJobPosition(),exc.getStartDate(),exc.getLeaveDate());
	}
	
	public static List<ExperienceDisplayDto> NormalToDisplayDto(List<Experience> experiences){
		 List<ExperienceDisplayDto> dtoList= new ArrayList<ExperienceDisplayDto>();
		 
		 for(Experience exp : experiences) {
			  dtoList.add(NormalToDisplayDto(exp));
		 }
		 return dtoList;
	}
}

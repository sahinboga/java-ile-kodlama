package kodlamaio.hrms.core.utilities.convertes;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDisplayDto;


public class EducationDtoconverter {
	
	public static EducationDisplayDto NormalToDisplayDto(Education education) {
		
		return new EducationDisplayDto(education.getSchool().getSchoolName(),education.getDepartment().getDepartmentName(),
										education.getStartDate(),education.getGraduationDate());
	}
	
	public static List<EducationDisplayDto> NormalToDisplayDto(List<Education> educations){
		 List<EducationDisplayDto> dtoList= new ArrayList<EducationDisplayDto>();
		 
		 for(Education edu : educations) {
			  dtoList.add(NormalToDisplayDto(edu));
		 }
		 return dtoList;
	}
}

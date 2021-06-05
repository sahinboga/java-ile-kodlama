package kodlamaio.hrms.core.utilities.convertes;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDisplayDto;
import kodlamaio.hrms.entities.dtos.ResumeForNewDto;

public class ResumeDtoConverter {
	
	public static ResumeForNewDto NormalToForNewDto(Resume normal) {
		
		return new ResumeForNewDto(normal.getJobSeeker().getUserId(),normal.getGithub(),normal.getLinkedin(),
									normal.getSummary(),normal.getImage().getId());
	}
	
	public List<ResumeForNewDto> NormalToForNewDto(List<Resume> resumeList){
		
		List<ResumeForNewDto> dtoList= new ArrayList<ResumeForNewDto>();
		
		for(Resume resume: resumeList) {
			dtoList.add(NormalToForNewDto(resume));
		}
		
		return dtoList;
	}
	
	public static Resume InputToNormalDto(ResumeForNewDto resumeDto) {
		
		return new Resume(resumeDto.getGithub(),resumeDto.getLinkedin(),
							resumeDto.getUserId(),resumeDto.getSummary(),resumeDto.getImageId());
	}
	
	public static List<Resume> InputToNormalDto(List<ResumeForNewDto> dtoList){
		
		List<Resume> normalList= new ArrayList<Resume>();
		
		for(ResumeForNewDto dto : dtoList) {
			
			normalList.add(InputToNormalDto(dto));
		}
		return normalList;
	}
	
	public static ResumeDisplayDto NormalToDisplayDto(Resume resume) {
		
		return new ResumeDisplayDto(resume.getJobSeeker().getFirstName(),resume.getJobSeeker().getLastName(),
								resume.getGithub(),resume.getLinkedin(),resume.getSummary(),
								LanguageDtoConverter.NormalToDisplayDto(resume.getJobSeeker().getLanguages()),
								ExperienceDtoconverter.NormalToDisplayDto(resume.getJobSeeker().getExperiences()),
								SkillDtoConverter.NormalToDisplayDto(resume.getJobSeeker().getSkills()),
								EducationDtoconverter.NormalToDisplayDto(resume.getJobSeeker().getEducations()));
	}
	
	public static List<ResumeDisplayDto> NormalToDisplayDto(List<Resume> resumeList){
		
		List<ResumeDisplayDto> dtoList = new ArrayList<ResumeDisplayDto>();
		
		for(Resume resume : resumeList) {
			
			dtoList.add(NormalToDisplayDto(resume));
		}
		return dtoList;
	}
	
	
}

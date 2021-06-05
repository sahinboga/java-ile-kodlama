package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobseekers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resumes","languages","experiences","skills","educations"})
public class JobSeeker extends User {
	
	
	@Column(name="tc_no")
	private String tcNo;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Resume> resumes;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Education> educations;
}

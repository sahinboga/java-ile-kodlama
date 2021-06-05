package kodlamaio.hrms.entities.concretes;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {
	
	public JobAdvertisement(String description, String city2, int minSalary2, int maxSalary2, int maxPerson2,
			Date date, Date deadline2, boolean b,int jobPositionId,int employerId) {
		this.definition=description;
		this.city=city2;
		this.minSalary=minSalary2;
		this.maxSalary=maxSalary2;
		this.maxPerson=maxPerson2;
		this.releaseDate=date;
		this.deadline=deadline2;
		this.isActive=b;
		//this.jobPosition.setId(jobPositionId);
		this.setJobPosition(new JobPosition(jobPositionId,null,null));
		Employer employer=new Employer();
		employer.setUserId(employerId);
		this.setEmployer(employer);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	//@Column(name="job_position_id")
	//private int jobPsitionId;
	
	@Column(name="definition")
	private String definition;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="max_person")
	private int maxPerson;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
}

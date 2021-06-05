package kodlamaio.hrms.entities.concretes;

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
@Table(name="cv")

public class Resume {
	
	public Resume( String github, String linkedin, int userId,String summary,int imageId) {

		//this.school= new School(schoolId,null,null);
		this.github=github;
		this.linkedin=linkedin;
		JobSeeker jobSeeker= new JobSeeker();
		jobSeeker.setUserId(userId);
		this.jobSeeker= jobSeeker;
		//this.department=new Department(departmentId,null,null);
		this.summary=summary;
		Image image= new Image();
		image.setId(imageId);
		this.image= image;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="image_id")
	private Image image;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="summary")
	private String summary;
	
}


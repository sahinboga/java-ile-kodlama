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
@Table(name="experiences")
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="starting_date")
	private Date startDate;
	
	@Column(name="leaving_date")
	private Date leaveDate;
}

package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
>>>>>>> Stashed changes
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
<<<<<<< Updated upstream
@Table(name="JobPositions")
=======
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
>>>>>>> Stashed changes
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	@Column(name="id")
	private int id;
	
<<<<<<< Updated upstream
	@Column(name="Name")
	private String name;
	
=======
	@Column(name="job_name")
	private String jobName;
	
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobAdvertisements;
>>>>>>> Stashed changes
	
}

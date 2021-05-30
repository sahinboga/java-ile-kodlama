package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
>>>>>>> Stashed changes
import lombok.Data;

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
	@GeneratedValue
	
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
	
	public JobPosition() {
		
	}

	public JobPosition(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

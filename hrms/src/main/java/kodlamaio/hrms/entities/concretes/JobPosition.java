package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="JobPositions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	
	public JobPosition() {
		
	}

	public JobPosition(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

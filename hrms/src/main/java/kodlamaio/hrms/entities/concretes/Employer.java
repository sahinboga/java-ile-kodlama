package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User {
	
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="is_comfirmed")
	private boolean isComfirmed;
	
}

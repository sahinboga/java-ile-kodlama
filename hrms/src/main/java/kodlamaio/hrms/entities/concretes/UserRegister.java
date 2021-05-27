package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_registers")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="activision_code")
	private String activision_code;
	
	@Column(name="is_comfirmed")
	private boolean is_comfirmed;
	
	@Column(name="comfirmed_date")
	private Date comfirmed_date;
	
	@Column(name="register_date")
	private Date register_date;
}

package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDisplayDto {
	 
	private String companyName;
	private String jobPositon;
	private Date startDate;
	private Date leaveDate;
}

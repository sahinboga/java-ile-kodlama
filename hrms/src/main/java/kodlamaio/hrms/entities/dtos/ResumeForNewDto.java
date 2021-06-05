package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeForNewDto {
	
	private int userId;
	private String github;
	private String linkedin;
	private String summary;
	private int imageId;
}

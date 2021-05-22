package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor; 

@Data //lombok --> Getter & Setter
@Entity //Which layer? Annotation
@Table(name="job_positions") //table
@NoArgsConstructor // no parameter constructor
@AllArgsConstructor // constructor with all fields

public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "position") //hatali dönülecek geri sonra
	private String position;
	
	@Column(name = "position_detail")
	private String positionDetails;
	
	
}

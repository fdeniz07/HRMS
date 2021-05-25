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
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "is_active")
	private boolean isActive;
}

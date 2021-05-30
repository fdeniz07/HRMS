package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	//Tüm Is Positionlari listelenecek
	List<JobPosition> findAllByPosition(String position);
}

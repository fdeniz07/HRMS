package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	//Candidate findByIdentificationNumber(String identificationNumber); // ileride tek kimlikno listelenecekse
	
	// Email ve Kimlik Numaralari listelenecek
	List<Candidate> findAllByEmail(String email);
	
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
	
}

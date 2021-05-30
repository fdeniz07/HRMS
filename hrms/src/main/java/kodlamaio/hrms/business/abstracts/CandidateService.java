package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	//DataResult<Candidate> findByIdentifacationNumber (String identificationNumber); //Istenilen basvuru yapanin kimlik numarasi
	
	//DataResult<List<Candidate>> findAllByEmail(String email); 
	
	//DataResult<List<Candidate>> findAllByIdentificationNumber(String identificationNumber);
		
    DataResult<List<Candidate>> findAll(); //Tüm isbasvurusu yapanlarin listesi
		
	Result add(Candidate candidate); 
	
	//DataResult<User> getByEmail(String email); // istenilen kullaniciya ait mail bilgisi. *ileride User, Candidate olarak degistirilecek*
}

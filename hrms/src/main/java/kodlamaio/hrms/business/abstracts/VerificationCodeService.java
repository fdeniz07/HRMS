package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	/*
	 * VerificationCode findByCode(String code); DataResult<List<VerificationCode>>
	 * findAllByCode(); String createActivationCode(User user); Result
	 * activateUser(String activationCode);
	 */
	
	void generateCode(VerificationCode code, Integer id);
	Result verify(String verificationCode, Integer id);
}

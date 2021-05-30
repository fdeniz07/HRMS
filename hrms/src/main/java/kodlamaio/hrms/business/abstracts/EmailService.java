package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface EmailService {

	void sendEmailVerify(User user, String code);
}

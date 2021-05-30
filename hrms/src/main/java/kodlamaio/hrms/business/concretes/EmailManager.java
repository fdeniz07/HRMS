package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public void sendEmailVerify(User user, String code) {
		
		
	}

}

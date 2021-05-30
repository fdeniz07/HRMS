package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserService {

	DataResult<List<User>> getAll();
	User add(User user);
}

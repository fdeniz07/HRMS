package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeService {

	Result add(ConfirmByEmployee confirmByEmployee);
}

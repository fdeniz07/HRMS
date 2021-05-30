package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	ConfirmByEmployeeDao confirmByEmployeeDao;

	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
	}

	@Override
	public Result add(ConfirmByEmployee confirmByEmployee) {
		this.confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("Basarili kayit");
	}

}

package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service // Which layer?
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao; // DI

	@Autowired // Bizim yerimize arkaplanda JobPositionDao'nun instance'ini aliyor. Eger
				// constructor varsa bir defa tanimlanir. Eger yoksa her DI'nin üzerinde
				// tanimlanir
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {

		return this.jobPositionDao.findAll();

	}

}

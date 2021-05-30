package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;


public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee, Integer>{


}

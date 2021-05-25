package kodlamaio.hrms.dataAccess.abstracts;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{

}

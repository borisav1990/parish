package bp.adiutor.parish.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bp.adiutor.parish.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
	@Transactional(readOnly = true)
	Optional<User> findByEmail(String email);
	
}
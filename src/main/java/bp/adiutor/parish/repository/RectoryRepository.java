package bp.adiutor.parish.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.User;

public interface RectoryRepository extends CrudRepository<Rectory, Integer> {
	
	@Transactional(readOnly = true)
	Optional<Rectory> findByUser(User userId);

}

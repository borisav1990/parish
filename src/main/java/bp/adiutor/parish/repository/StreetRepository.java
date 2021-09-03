package bp.adiutor.parish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.Street;

public interface StreetRepository extends CrudRepository <Street, Integer> {
	
	@Transactional(readOnly = true)
	List<Street> findByRectory(Rectory rectory);

}

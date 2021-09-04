package bp.adiutor.parish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	@Transactional(readOnly = true)
	List<Person> findByHousehold(Household household);
	
	

}

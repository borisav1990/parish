package bp.adiutor.parish.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.Street;

public interface HouseholdRepository extends CrudRepository <Household, Integer>{
	
	@Transactional(readOnly = true)
	Optional<Household> findByHouseholdIdAndRectory(Integer houseldId, Rectory rectory);
	
	@Transactional(readOnly = true)
	List<Household> findByRectory(Rectory rectory);
	
	@Transactional(readOnly = true)
	List<Household> findByStreet(Street street);
	}

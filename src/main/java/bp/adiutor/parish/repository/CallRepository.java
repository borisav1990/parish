package bp.adiutor.parish.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bp.adiutor.parish.model.Call;
import bp.adiutor.parish.model.Household;

public interface CallRepository extends CrudRepository<Call, Integer> {
	
	@Transactional(readOnly = true)
	List<Call> findAllByHousehold(Household household);

}

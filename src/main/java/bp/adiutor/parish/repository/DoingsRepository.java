package bp.adiutor.parish.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bp.adiutor.parish.model.Deed;
import bp.adiutor.parish.model.Doing;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Rectory;

public interface DoingsRepository extends CrudRepository<Doing, Integer>{
	
	@Transactional(readOnly = true)
	List<Doing> findByRectory(Rectory rectory);
	
	@Transactional(readOnly = true)
	List<Doing> findByRectoryAndReservedAt(Rectory r, Date reservedAt);
	
	@Transactional(readOnly = true)
	List<Doing> findByHousehold(Household household);
	
	@Transactional(readOnly = true)
	List<Doing> findByRectoryAndDeed(Rectory r, Deed deed);
	
	@Transactional(readOnly = true)
	List<Doing> findByRectoryAndHousehold(Rectory r, Household hh);
	
	@Transactional(readOnly = true)
	Optional<Doing> findByDoingsIdAndRectory(Integer doingId, Rectory rectory);
	
	
	
	

}

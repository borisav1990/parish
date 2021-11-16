package bp.adiutor.parish.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bp.adiutor.parish.model.Eparchy;

@Repository
public interface EparchyRepository extends CrudRepository<Eparchy, Integer> {
	
    }

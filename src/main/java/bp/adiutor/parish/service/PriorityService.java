package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Priority;

public interface PriorityService {
	
    List<Priority> getAllPriority();
	
	Priority getPriorityById(Integer id);
	
	Priority createPriority(Priority priority);
	
	Priority updatePriority(Priority priority);
	
	void deleteById(Integer id);

}

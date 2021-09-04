package bp.adiutor.parish.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.Priority;
import bp.adiutor.parish.repository.PriorityRepository;
import bp.adiutor.parish.service.PriorityService;


@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {
	
	private static final Logger logger = LoggerFactory.getLogger(PriorityServiceImpl.class);
	
	@Autowired
	private PriorityRepository priorityRepository;
	
	@Override
	public List<Priority> getAllPriority() {
		logger.info("Will get for: getAllPriority()");
		return (List<Priority>) priorityRepository.findAll();
	}

	@Override
	public Priority getPriorityById(Integer id) {
		logger.info("Will get for: getPriorityById({})", id);
		return priorityRepository.findById(id).get();
	}

	@Override
	public Priority createPriority(Priority priority) {
		logger.info("Will create: createPriority for name={}", priority.getName());
		return priorityRepository.save(priority);
		}

	@Override
	public Priority updatePriority(Priority priority) {
		logger.info("Will updated: updatePriority for name={}", priority.getName());
		return priorityRepository.save(priority);
		
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		priorityRepository.deleteById(id);
		}

}


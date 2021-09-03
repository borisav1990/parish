package bp.adiutor.parish.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.Patron;
import bp.adiutor.parish.repository.PatronRepository;
import bp.adiutor.parish.service.PatronService;


@Service
@Transactional
public class PatronServiceImpl implements PatronService {

	private static final Logger logger = LoggerFactory.getLogger(PatronServiceImpl.class);
	
	@Autowired
	private PatronRepository patronRepository;
	
	@Override
	public List<Patron> getAllPatron() {
		logger.info("Will get for: getAllPatron()");
		return (List<Patron>) patronRepository.findAll();
	}

	@Override
	public Patron getPatronById(Integer id) {
		logger.info("Will get for: getPatronById({})", id);
		return patronRepository.findById(id).get();
	}

	@Override
	public Patron createPatron(Patron patron) {
		logger.info("Will create: createPatron for name={}", patron.getName());
		return patronRepository.save(patron);
	}

	@Override
	public Patron updatePatron(Patron patron) {
		logger.info("Will updated: updatePatron for name={}", patron.getName());
		return patronRepository.save(patron);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete Patron: deleteById({})", id);
		patronRepository.deleteById(id);
	}
}

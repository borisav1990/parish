package bp.adiutor.parish.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.Kinship;
import bp.adiutor.parish.repository.KinshipRepository;
import bp.adiutor.parish.service.KinshipService;


@Service
@Transactional
public class KinshipServiceImpl implements KinshipService {

	private static final Logger logger = LoggerFactory.getLogger(KinshipServiceImpl.class);
	
	@Autowired
	private KinshipRepository kinshipRepository;
	
	@Override
	public List<Kinship> getAllKinship() {
		logger.info("Will get for: getAllKinship()");
		return (List<Kinship>) kinshipRepository.findAll();
	}

	@Override
	public Kinship getKinshipById(Integer id) {
		logger.info("Will get for: getKinshipById({})", id);
		return kinshipRepository.findById(id).get();
	}

	@Override
	public Kinship createKinship(Kinship kinship) {
		logger.info("Will create: createKinship for name={}", kinship.getName());
		return kinshipRepository.save(kinship);
	}

	@Override
	public Kinship updateKinship(Kinship kinship) {
		logger.info("Will updated: updateKinship for name={}", kinship.getName());
		return kinshipRepository.save(kinship);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete Kinship: deleteById({})", id);
		kinshipRepository.deleteById(id);
	}
}

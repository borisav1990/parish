package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.Deed;
import bp.adiutor.parish.repository.DeedRepository;
import bp.adiutor.parish.service.DeedService;


@Service
@Transactional
public class DeedServiceImpl implements DeedService {
	
	private static final Logger logger = LoggerFactory.getLogger(DeedServiceImpl.class);
	
	@Autowired
	private DeedRepository DeedRepository;
	
	@Override
	public List<Deed> getAllDeed() {
		logger.info("Will get for: getAllDeed()");
		return (List<Deed>) DeedRepository.findAll();
	}

	@Override
	public Deed getDeedById(Integer id) {
		logger.info("Will get for: getDeedById({})", id);
		return DeedRepository.findById(id).get();
	}

	@Override
	public Deed createDeed(Deed Deed) {
		logger.info("Will create: createDeed for name={}", Deed.getName());
		return DeedRepository.save(Deed);
		}

	@Override
	public Deed updateDeed(Deed Deed) {
		logger.info("Will updated: updateDeed for name={}", Deed.getName());
		return DeedRepository.save(Deed);
		
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		DeedRepository.deleteById(id);
		}

}

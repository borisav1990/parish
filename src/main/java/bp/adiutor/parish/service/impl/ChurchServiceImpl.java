package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Church;
import bp.adiutor.parish.model.User;
import bp.adiutor.parish.repository.ChurchRepository;
import bp.adiutor.parish.service.ChurchService;
import bp.adiutor.parish.service.UserService;

@Service
@Transactional
public class ChurchServiceImpl implements ChurchService {
	
	private static final Logger logger = LoggerFactory.getLogger(ChurchServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChurchRepository churchRepository;

	@Override
	public List<Church> getAllChurch() {
		logger.info("Will get for: getAllChurch()");
		return (List<Church>) churchRepository.findAll();
	}

	@Override
	public Church getChurchById(Integer id) {
		logger.info("Will get for: getChurchById({})", id);
		return churchRepository.findById(id).get();
	}

	@Override
	public Church getChurchByUser(Integer id) {
		User user = userService.getLoggedUser();
		logger.info("Will get for: getChurchByUser({})", user.getUserId());
		return user.getChurch();
		}
	

	@Override
	public Church createChurch(Church church) {
		logger.info("Will create: createChurch for name={}", church.getSaint());
		return churchRepository.save(church);
	}

	@Override
	public Church updateChurch(Church church) {
		logger.info("Will updated: updateChurch for name={}", church.getSaint());
		return churchRepository.save(church);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		churchRepository.deleteById(id);
		}

}

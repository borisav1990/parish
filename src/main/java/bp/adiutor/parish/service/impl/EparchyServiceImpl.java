package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Eparchy;
import bp.adiutor.parish.model.User;
import bp.adiutor.parish.repository.EparchyRepository;
import bp.adiutor.parish.service.EparchyService;
import bp.adiutor.parish.service.UserService;

@Service
@Transactional
public class EparchyServiceImpl implements EparchyService {
	
	private static final Logger logger = LoggerFactory.getLogger(EparchyServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EparchyRepository eparchyRepository;
	
	@Override
	public List<Eparchy> getAllEparchy() {
		logger.info("Will get for: getAllEparchy()");
		return (List<Eparchy>) eparchyRepository.findAll();
	}

	@Override
	public Eparchy getEparchyById(Integer id) {
		logger.info("Will get for: getEparchyById({})", id);
		return eparchyRepository.findById(id).get();
	}

	@Override
	public Eparchy getEparchyByUser(Integer id) {
		User user = userService.getLoggedUser();
		logger.info("Will get for: getEparchyByUser({})", user.getUserId());
		return user.getChurch().getEparchy();
		}

	@Override
	public Eparchy createEparchy(Eparchy eparchy) {
		logger.info("Will create: createEparchy for name={}", eparchy.getName());
		return eparchyRepository.save(eparchy);
		}

	@Override
	public Eparchy updateEparchy(Eparchy eparchy) {
		logger.info("Will updated: updateEparchy for name={}", eparchy.getName());
		return eparchyRepository.save(eparchy);
		
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		eparchyRepository.deleteById(id);
		}

}

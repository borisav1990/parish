package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.User;
import bp.adiutor.parish.repository.RectoryRepository;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.UserService;

@Service
@Transactional
public class RectoryServiceImpl implements RectoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(RectoryServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RectoryRepository rectoryRepository;

	@Override
	public List<Rectory> getAllRectory() {
		logger.info("Will get for: getAllRectory()");
		return (List<Rectory>) rectoryRepository.findAll();
	}

	@Override
	public Rectory getRectoryById(Integer id) {
		logger.info("Will get for: getRectoryById({})", id);
		return rectoryRepository.findById(id).get();
	}

	@Override
	public Rectory getRectoryByUser(){
		User user = userService.getLoggedUser();
		logger.info("Will get for: getRectoryByUser({})", user.getUserId());
		return rectoryRepository.findByUser(user).get();
	}

	@Override
	public Rectory createRectory(Rectory rectory) {
		logger.info("Will create: createRectory for name={}", rectory.getRectoryName());
		return rectoryRepository.save(rectory);
	}
    
	@Override
	public Rectory updateRectory(Rectory rectory) {
		logger.info("Will updated: updateRectory for name={}", rectory.getRectoryName());
		return rectoryRepository.save(rectory);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		rectoryRepository.deleteById(id);
		}
	}

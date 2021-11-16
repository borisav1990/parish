package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.Street;
import bp.adiutor.parish.repository.StreetRepository;
import bp.adiutor.parish.service.CityService;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.StreetService;


@Service
@Transactional
public class StreetServiceImpl implements StreetService {
	
	private static final Logger logger = LoggerFactory.getLogger(StreetServiceImpl.class);
	
	@Autowired
	private StreetRepository streetRepository;
	
	@Autowired
	private RectoryService rectoryService;
	
	@Autowired
	private CityService cityService;
	

	@Override
	public List<Street> getAllStreet() {
		logger.info("Will get for: getAllStreet()");
		return null;
	}

	@Override
	public List<Street> getAllStreetByRectory() {
		Rectory r = rectoryService.getRectoryByUser();
		logger.info("Will get for: getAllStreetByRectory(rectoryId:{})", r.getRectoryId());
		return streetRepository.findByRectory(r);
	}

	@Override
	public Street getStreetById(Integer id) {
		logger.info("Will get for: getStreetById(streetId:{})", id);
		return streetRepository.findById(id).get();
	}

	@Override
	public Street createStreet(Street street) {
		logger.info("Will create: createStreet for NAME={}", street.getName());
		street.setRectory(rectoryService.getRectoryByUser());
		Street saved = streetRepository.save(street);
		saved.setCity(cityService.getCityById(saved.getCity().getCityId()));
		return saved ;
		
	}

	@Override
	public Street updateStreet(Street street) {
		logger.info("Will create: updatedStreet for streetID={}", street.getStreetId());
		return streetRepository.save(street);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for Street: deleteById({})", id);
		streetRepository.deleteById(id);
	}

}

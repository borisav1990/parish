package bp.adiutor.parish.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.City;
import bp.adiutor.parish.repository.CityRepository;
import bp.adiutor.parish.service.CityService;


@Service
@Transactional
public class CityServiceImpl implements CityService {

	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> getAllCity() {
		logger.info("Will get for: getAllCity()");
		return (List<City>) cityRepository.findAll();
	}

	@Override
	public City getCityById(Integer id) {
		logger.info("Will get for: getCityById({})", id);
		return cityRepository.findById(id).get();
	}

	@Override
	public City createCity(City city) {
		logger.info("Will create: createCity for name={}", city.getName());
		return cityRepository.save(city);
	}

	@Override
	public City updateCity(City city) {
		logger.info("Will updated: updateCity for name={}", city.getName());
		return cityRepository.save(city);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete City: deleteById({})", id);
		cityRepository.deleteById(id);
	}
}

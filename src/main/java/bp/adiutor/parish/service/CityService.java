package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.City;

public interface CityService {
	
    List<City> getAllCity();
	
	City getCityById(Integer id);
	
	City createCity(City city);
	
	City updateCity(City city);
	
	void deleteById(Integer id);

}

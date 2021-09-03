package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.Street;

public interface StreetService {
	
    List<Street> getAllStreet();
    
    List<Street> getAllStreetByRectory();
	
	Street getStreetById(Integer id);
	
	Street createStreet(Street street);
	
	Street updateStreet(Street street);
	
	void deleteById(Integer id);

}

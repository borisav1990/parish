package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Church;

public interface ChurchService {
	
	List<Church> getAllChurch();
	
	Church getChurchById(Integer id);
	
	Church getChurchByUser(Integer id);
	
	Church createChurch(Church church);
	
	Church updateChurch(Church church);
	
	void deleteById(Integer id);

}

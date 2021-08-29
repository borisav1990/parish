package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Eparchy;

public interface EparchyService{
	
	List<Eparchy> getAllEparchy();
	
	Eparchy getEparchyById(Integer id);
	
	Eparchy getEparchyByUser(Integer id);
	
	Eparchy createEparchy(Eparchy eparchy);
	
	Eparchy updateEparchy(Eparchy eparchy);
	
	void deleteById(Integer id);
}

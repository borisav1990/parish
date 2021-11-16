package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Deed;

public interface DeedService{
	
	List<Deed> getAllDeed();
	
	Deed getDeedById(Integer id);
	
	Deed createDeed(Deed Deed);
	
	Deed updateDeed(Deed Deed);
	
	void deleteById(Integer id);
}
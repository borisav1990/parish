package bp.adiutor.parish.service;

import java.util.Date;
import java.util.List;

import bp.adiutor.parish.model.Deed;
import bp.adiutor.parish.model.Doing;
import bp.adiutor.parish.model.Household;

public interface DoingsService {
	
    List<Doing> getAllDoings();
    
    List<Doing> getAllDoingsByRectory();
    
    List<Doing> getAllDoingsByReservedTerimn(Date reservedAT);
    
    List<Doing> getAllDoingsByDeed(Deed deed);
    
    List<Doing> getAllDoingsByHousehold(Household hh);
    
    Doing getDoingById(Integer id);
	
	Doing createDoing(Doing doing);
	
	Doing updateDoing(Doing doing);
	
	void deleteById(Integer id);

	
	

}

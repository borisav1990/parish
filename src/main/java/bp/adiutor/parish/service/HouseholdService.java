package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Rectory;

public interface HouseholdService {
	
    List<Household> getAllHousehold();
    
    Household getHouseHoldById(Integer householdId);
    
    Household getHouseholdByIdAndRectory(Integer householdId, Rectory rectory);
	
	List<Household> getHouseholdByRectory();
	
	List<Household> getHouseholdByStreet(Integer streetId);
	
	List<Household> getHouseholdByPatron(Integer patronId);
	
	List<Household> getHouseholdByEaster(boolean easter);
	
	Household createHousehold(Household household);
	
	Household updateHousehold(Household household);
	
	void deleteById(Integer id);
	

}

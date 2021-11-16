package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Household;

public interface HouseholdService {
	
    List<Household> getAllHousehold();
    
    Household getHouseHoldById(Integer householdId);
    
	List<Household> getHouseholdByRectory();
	
	List<Household> getHouseholdByStreet(Integer streetId);
	
	List<Household> getHouseholdByPatron(Integer patronId);
	
	List<Household> getHouseholdByEaster(boolean easter);
	
	List<Household> getHouseholdByPriority(Integer priorityId);
	
	Household createHousehold(Household household);
	
	Household updateHousehold(Household household);
	
	void deleteById(Integer id);

	Household getHouseholdByIdAndRectory(Integer householdId);
	

}

package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Person;
import bp.adiutor.parish.model.Rectory;

public interface PersonService {
	
    List<Person> getAllPerson();
    
    List<Person> getAllPersonByHousehold(Household household);
	
	Person getPersonById(Integer id);
	
	Person createPerson(Person person);
	
	Person updatePerson(Person person);
	
	void deleteById(Integer id, Integer householdId, Rectory rectory);

}

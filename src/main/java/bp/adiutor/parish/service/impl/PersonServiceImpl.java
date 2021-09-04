package bp.adiutor.parish.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Person;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.repository.PersonRepository;
import bp.adiutor.parish.service.HouseholdService;
import bp.adiutor.parish.service.PersonService;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private HouseholdService householdService;
	
	@Override
	public List<Person> getAllPerson() {
		logger.info("Will get for: getAllPerson()");
		return (List<Person>) personRepository.findAll();
	}
	
	@Override
	public List<Person> getAllPersonByHousehold(Household household) {
		logger.info("Will get for: getAllPerson()");
		return (List<Person>)personRepository.findByHousehold(household);
		
	}
	
	@Override
	public Person getPersonById(Integer id) {
		logger.info("Will get for: getPersonById({})", id);
		return personRepository.findById(id).get();
	}

	@Override
	public Person createPerson(Person person) {
		logger.info("Will create: createPerson for name={}", person.getFirstName());
		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(Person person) {
		logger.info("Will updated: updatePerson for name={}", person.getFirstName());
		return personRepository.save(person);
	}

	@Override
	public void deleteById(Integer id, Integer householdId, Rectory rectory) {
		Household h = householdService.getHouseholdByIdAndRectory(householdId, rectory);
		List<Person> p = h.getPersons();
		for (Person person : p) {
			if(person.getPersonId() == id);
			logger.info("Will delete Person: deleteById({})", id);
			personRepository.deleteById(id);
		}
		
	}

}

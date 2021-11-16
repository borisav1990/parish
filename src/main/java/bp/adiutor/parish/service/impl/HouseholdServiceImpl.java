package bp.adiutor.parish.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Patron;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.Street;
import bp.adiutor.parish.repository.HouseholdRepository;
import bp.adiutor.parish.service.HouseholdService;
import bp.adiutor.parish.service.PatronService;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.StreetService;

@Service
@Transactional
public class HouseholdServiceImpl implements HouseholdService {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseholdServiceImpl.class);
	
	@Autowired
	private HouseholdRepository householdRepository;
	
	@Autowired
	private RectoryService rectoryService;
	
	@Autowired
	private StreetService streetService;
	
	@Autowired
	private PatronService patronService;
	
    @Override
	public List<Household> getAllHousehold() {
		logger.info("Will get for: getAllHousehold()");
		return (List<Household>) householdRepository.findAll();
	}

	@Override
	public Household getHouseHoldById(Integer householdId) {
		logger.info("Will get for: getHouseHoldById({})", householdId);
		return householdRepository.findById(householdId).get();
	}

	@Override
	public Household getHouseholdByIdAndRectory(Integer householdId) {
		Rectory r = rectoryService.getRectoryByUser();
		logger.info("Will get for: getHouseholdByIdAndRectory(householdId:{}, rectoryId:{})", householdId, r.getRectoryId());
		return householdRepository.findByHouseholdIdAndRectory(householdId, r).get();
	}

	@Override
	public List<Household> getHouseholdByRectory() {
		Rectory r = rectoryService.getRectoryByUser();
		logger.info("Will get for: getHouseholdByRectory(rectoryId:{})",r.getRectoryId());
		return householdRepository.findByRectory(r);
	}

	@Override
	public List<Household> getHouseholdByStreet(Integer streetId) {
		logger.info("Will get for: getHouseholdByStreet(streetId:{})",streetId);
		List<Street> streets = streetService.getAllStreetByRectory();
		for (Street street : streets) {
			if (street.getStreetId() == streetId) {
				logger.info("Will get OK: getHouseholdByStreet(streetId:{})",street.getStreetId());
				return householdRepository.findByStreet(street);
				}
			}
		logger.info("Will get EMPTY LIST: getHouseholdByStreet(streetId:{})",streetId);
		List<Household> emptyList = new ArrayList<>();
		return emptyList;
	}

	@Override
	public List<Household> getHouseholdByPatron(Integer patronId){
		logger.info("Will get: getHouseholdByPatron(patronId:{})",patronId);
		List<Household> houses = new ArrayList<>();
		Patron p = patronService.getPatronById(patronId);
		List<Household> householdsRectory = getHouseholdByRectory();
		List<Household> householdsPatron = p.getHouseholds();
		for (Household hr : householdsRectory) {
			for (Household hp : householdsPatron) {
				if(hr.getHouseholdId() == hp.getHouseholdId()) {
					houses.add(hr);
				}
			}
		}
		return houses;
	}

	@Override
	public List<Household> getHouseholdByEaster(boolean easter) {
		logger.info("Will get for: getHouseholdEaster(easter:{})",easter);
		List<Household> householdsEaster = new ArrayList<>();
		List<Household> householdsRectory = getHouseholdByRectory();
		for (Household household : householdsRectory) {
			if(household.isEaster() == easter) {
				householdsEaster.add(household);
				}
			}
		 return householdsEaster;
	}
	
	@Override
	public List<Household> getHouseholdByPriority(Integer priorityId) {
		logger.info("Will get for: getHouseholdByPriority(priorityId:{})",priorityId);
		List<Household> householdsPriority = new ArrayList<>();
		List<Household> householdsRectory = getHouseholdByRectory();
		for (Household household : householdsRectory) {
			if(household.getPriority().getPriorityId() == priorityId) {
				householdsPriority.add(household);
				}
			}
		 return householdsPriority;
	}

	@Override
	public Household createHousehold(Household household) {
		logger.info("Will create: createHousehold for rectory={}", household.getRectory());
		return householdRepository.save(household);
	}

	@Override
	public Household updateHousehold(Household household) {
		logger.info("Will updated: updateHousehold for rectory={}", household.getRectory());
		return householdRepository.save(household);
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		Rectory r = rectoryService.getRectoryByUser();
		Household h = householdRepository.findById(id).get();
		if(r.getRectoryId() == h.getRectory().getRectoryId()) {
				householdRepository.deleteById(id);
		}
	}

}

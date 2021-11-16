package bp.adiutor.parish.service.impl;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Deed;
import bp.adiutor.parish.model.Doing;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.repository.DoingsRepository;
import bp.adiutor.parish.service.DoingsService;
import bp.adiutor.parish.service.RectoryService;


@Service
@Transactional
public class DoingsServiceImpl implements DoingsService{
	
	private static final Logger logger = LoggerFactory.getLogger(StreetServiceImpl.class);
	
	@Autowired
	private DoingsRepository doingsRepository;
	
	@Autowired
	private RectoryService rectoryService;
	
	@Override
	public List<Doing> getAllDoings() {
		logger.info("Will get for: getAllDoings()");
		return (List<Doing>) doingsRepository.findAll(); 
	}

	@Override
	public List<Doing> getAllDoingsByRectory() {
		logger.info("Will get for: getAllDoingsByRectory()");
		Rectory r = rectoryService.getRectoryByUser();
		return doingsRepository.findByRectory(r);
	}

	@Override
	public List<Doing> getAllDoingsByReservedTerimn(Date reservedAt) {
		logger.info("Will get for: getAllDoingsByReservedTerimn(reservedAt:{})", reservedAt);
		Rectory r = rectoryService.getRectoryByUser();
		return doingsRepository.findByRectoryAndReservedAt(r, reservedAt);
	}

	@Override
	public List<Doing> getAllDoingsByDeed(Deed deed) {
		logger.info("Will get for: getAllDoingsByDeed(deed:{})", deed.getDeedId());
		Rectory r = rectoryService.getRectoryByUser();
		return doingsRepository.findByRectoryAndDeed(r, deed);
		
	}
	
	@Override
	public List<Doing> getAllDoingsByHousehold(Household hh) {
		logger.info("Will get for: getAllDoingsByHousehold(householdId:{})", hh.getHouseholdId());
		Rectory r = rectoryService.getRectoryByUser();
		return doingsRepository.findByRectoryAndHousehold(r, hh);
		
	}

	@Override
	public Doing getDoingById(Integer id) {
		logger.info("Will get for: getDoingById({})", id);
		Rectory r = rectoryService.getRectoryByUser();
		return doingsRepository.findByDoingsIdAndRectory(id, r).get();
	}

	@Override
	public Doing createDoing(Doing doing) {
		logger.info("Will create: createDoing for doingID={}", doing.getDoingsId());
		Rectory r = rectoryService.getRectoryByUser();
	    doing.setRectory(r);
	    return doingsRepository.save(doing);
	}

	@Override
	public Doing updateDoing(Doing doing) {
		logger.info("Will updated: updatedDoing for doingID={}", doing.getDoingsId());
		Doing d = getDoingById(doing.getDoingsId());
		if (d != null) {
			return doingsRepository.save(doing);
			}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for Doing: deleteById({})", id);
		Doing d = getDoingById(id);
		if (d != null) {
			doingsRepository.deleteById(d.getDoingsId());
			}
		}

}

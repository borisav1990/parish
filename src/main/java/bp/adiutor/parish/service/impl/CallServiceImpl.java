package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Call;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.repository.CallRepository;
import bp.adiutor.parish.service.CallService;
import bp.adiutor.parish.service.HouseholdService;


@Service
@Transactional
public class CallServiceImpl implements CallService {
	
	private static final Logger logger = LoggerFactory.getLogger(CallServiceImpl.class);
		
	@Autowired
	private CallRepository callRepository;
	
	@Autowired
	private HouseholdService householdService;
	
	@Override
	public List<Call> getAllCallByHousehold(Household household) {
		logger.info("Will get for: getAllCall()");
		return callRepository.findAllByHousehold(household);
	}

	@Override
	public Call getCallById(Integer id) {
		Call call = callRepository.findById(id).get();
		Household hh = householdService.getHouseholdByIdAndRectory(call.getHousehold().getHouseholdId());
		if(hh.getCalls().contains(call)){
			logger.info("Will get for: getCallById({})", id);
			return call;
		}
		return null;
	}

	@Override
	public Call createCall(Call call) {
		Household hh = householdService.getHouseholdByIdAndRectory(call.getHousehold().getHouseholdId());
		if(hh != null){
			logger.info("Will create: createCall()");
			return callRepository.save(call);
		}
		return null;
	}

	@Override
	public Call updateCall(Call call) {
		Call c = getCallById(call.getCallId());
		if(c != null) {
			logger.info("Will updated: updateCall()");
			return callRepository.save(c);
			}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		Call c =  getCallById(id);
		callRepository.delete(c);
		}

	@Override
	public List<Call> getAllCall() {
		return (List<Call>) callRepository.findAll();
		}

}

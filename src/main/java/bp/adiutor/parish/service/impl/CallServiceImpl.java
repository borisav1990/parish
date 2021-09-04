package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bp.adiutor.parish.model.Call;
import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.repository.CallRepository;
import bp.adiutor.parish.service.CallService;
import bp.adiutor.parish.service.RectoryService;

@Service
@Transactional
public class CallServiceImpl implements CallService {
	
	private static final Logger logger = LoggerFactory.getLogger(CallServiceImpl.class);
		
	@Autowired
	private CallRepository callRepository;
	
	@Autowired
	private RectoryService rectoryService;

	@Override
	public List<Call> getAllCall() {
		logger.info("Will get for: getAllCall()");
		return (List<Call>) callRepository.findAll();
	}

	@Override
	public Call getCallById(Integer id) {
		logger.info("Will get for: getCallById({})", id);
		return callRepository.findById(id).get();
	}

	@Override
	public Call createCall(Call call) {
		logger.info("Will create: createCall()");
		return callRepository.save(call);
	}

	@Override
	public Call updateCall(Call call) {
		logger.info("Will updated: updateCall()");
		return callRepository.save(call);
	}

	@Override
	public void deleteById(Integer id) {
		Rectory r = rectoryService.getRectoryByUser();
		List<Household> h = r.getHouseholds();
		for (Household household : h) {
			List<Call> c = household.getCalls();
			for (Call call : c) {
				if(call.getCallId() == id) {
					logger.info("Will delete for: deleteById({})", id);
					callRepository.deleteById(id);
					}
				}
			}
		
		}

}

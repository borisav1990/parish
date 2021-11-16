package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Call;
import bp.adiutor.parish.model.Household;

public interface CallService {
	
    List<Call> getAllCall();
	
	Call getCallById(Integer id);
	
	Call createCall(Call call);
	
	Call updateCall(Call call);
	
	void deleteById(Integer id);

	List<Call> getAllCallByHousehold(Household household); 

}

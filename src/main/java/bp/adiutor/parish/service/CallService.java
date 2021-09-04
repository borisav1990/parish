package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Call;

public interface CallService {
	
    List<Call> getAllCall();
	
	Call getCallById(Integer id);
	
	Call createCall(Call call);
	
	Call updateCall(Call call);
	
	void deleteById(Integer id); 

}

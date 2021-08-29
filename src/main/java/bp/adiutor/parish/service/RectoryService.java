package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Rectory;

public interface RectoryService {
	
    List<Rectory> getAllRectory();
	
	Rectory getRectoryById(Integer id);
	
	Rectory getRectoryByUser();
	
	Rectory createRectory(Rectory rectory);
	
	Rectory updateRectory(Rectory rectory);
	
	void deleteById(Integer id);

}

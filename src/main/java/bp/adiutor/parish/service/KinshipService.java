package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Kinship;

public interface KinshipService {
	
    List<Kinship> getAllKinship();
	
	Kinship getKinshipById(Integer id);
	
	Kinship createKinship(Kinship kinship);
	
	Kinship updateKinship(Kinship kinship);
	
	void deleteById(Integer id);

}

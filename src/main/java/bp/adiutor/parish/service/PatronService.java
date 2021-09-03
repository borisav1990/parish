package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.Patron;

public interface PatronService {
	
    List<Patron> getAllPatron();
	
	Patron getPatronById(Integer id);
	
	Patron createPatron(Patron patron);
	
	Patron updatePatron(Patron patron);
	
	void deleteById(Integer id);

}

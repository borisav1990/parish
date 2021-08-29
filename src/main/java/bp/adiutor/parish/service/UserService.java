package bp.adiutor.parish.service;

import java.util.List;

import bp.adiutor.parish.model.User;


public interface UserService{
	
	List<User> getAllUser();
	
	User getLoggedUser();
	
	User getUserById(Integer id);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteById(Integer id);

}

package bp.adiutor.parish.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bp.adiutor.parish.model.User;
import bp.adiutor.parish.repository.UserRepository;
import bp.adiutor.parish.security.AuthUser;
import bp.adiutor.parish.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private AuthUser auth; 
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		logger.info("Will get for: getAllUser");
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		logger.info("Will get for: getUserById for id={}", id);
		return userRepository.findById(id).get();
	}

	@Override
	public User createUser(User user) {
		logger.info("Will create: createUser for email={}", user.getEmail());
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		logger.info("Will updated: updateUser for email={}", user.getEmail());
		return userRepository.save(user);
	}

	@Override
	public User getLoggedUser() {
		logger.info("Will get logged user for: getLoggedUser()");
		String email = auth.getAuthentication().getName();
		return userRepository.findByEmail(email).get();
		}

	@Override
	public void deleteById(Integer id) {
		logger.info("Will delete for: deleteById({})", id);
		userRepository.deleteById(id);
		
	}

}

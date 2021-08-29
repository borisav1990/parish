package bp.adiutor.parish.controller;

import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bp.adiutor.parish.ParishApplication;
import bp.adiutor.parish.model.Rectory;
import bp.adiutor.parish.model.User;
import bp.adiutor.parish.repository.UserRepository;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.UserService;

@RestController("/")

public class UserController {
	
	//Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RectoryService rectoryService;
	
	@RequestMapping(value="/boro", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	
	public String boro(Locale locale)  {
		
		ParishApplication.logger.info("{}", messageSource.getMessage("l2", new Object[] {"Neka poruka"}, Locale.ENGLISH));
		
		//User user = userService.getLoggedUser();
		//System.out.println(user.getChurch().getEparchy().getName());
		System.out.println("------------------");
		Rectory rectory = rectoryService.getRectoryByUser();
		System.out.println("-----" + rectory.getRectoryName());
         
		
		return "Borisav";
		
		
		
		
		
		}

}

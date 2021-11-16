package bp.adiutor.parish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParishApplication {
	
	public static Logger logger = LoggerFactory.getLogger(ParishApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ParishApplication.class, args);
		}
	
	
	
	
	

}

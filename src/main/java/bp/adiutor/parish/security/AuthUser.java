package bp.adiutor.parish.security;

import org.springframework.security.core.Authentication;

public interface AuthUser {
    
	Authentication getAuthentication();
}

package nhathuoclankha.auth.service;

import nhathuoclankha.exceptions.AuthorizationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.auth.model.UserDetailCustom;

@Service
@Slf4j
public class SecurityService {
	public String getUserName() {
		try {
			UserDetailCustom user = (UserDetailCustom) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			return user != null ? user.getUsername() : "";
		}
		catch (ClassCastException ex){
			log.error(">>anonymousUser!");
			throw new AuthorizationException("Đang là anonymousUser!");
		}
		catch (Exception e) {
			log.error(">> get user name failed!");
		}
		return "";

	}

}

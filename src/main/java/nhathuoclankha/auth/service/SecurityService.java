package nhathuoclankha.auth.service;

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
		} catch (Exception e) {
			log.info(">> get user name failed!");
		}
		return "";

	}

}

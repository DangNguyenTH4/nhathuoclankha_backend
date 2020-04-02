package nhathuoclankha.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import nhathuoclankha.auth.dto.JwtRequest;
import nhathuoclankha.auth.dto.JwtResponse;

public interface AuthenService extends UserDetailsService  {
	JwtResponse authen(JwtRequest jwtRequest);
	UserDetails loadUserById(Long userId);
}

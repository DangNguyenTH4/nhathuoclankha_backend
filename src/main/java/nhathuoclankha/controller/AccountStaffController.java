package nhathuoclankha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhathuoclankha.auth.dto.JwtResponse;
import nhathuoclankha.auth.model.User;
import nhathuoclankha.auth.repository.UserRepository;
import nhathuoclankha.dto.UserDto;
import nhathuoclankha.factory.Factory;
import nhathuoclankha.utils.RoleConstant;

@RestController
@RequestMapping("/account")
public class AccountStaffController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	  
	@PostMapping("/new-account")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> createAccount(UserDto user){
		if(user==null || StringUtils.isEmpty(user.getUsername())) {
			return new ResponseEntity<>("Username trống.", HttpStatus.BAD_REQUEST);
		}else {
			User existedUser = userRepository.findByUsername(user.getUsername());
		    if (existedUser != null) {
		    	existedUser = Factory.getUserInstant();
		    	existedUser.setUsername(user.getUsername());
		    	existedUser.setRole(RoleConstant.ROLEADMIN);
		    	existedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		      userRepository.save(existedUser);
		      return new ResponseEntity<>("Tạo thành công",HttpStatus.CREATED);
		    }
		    else {
		    	return  new ResponseEntity<>("Tài khoản đã tồn tại.",HttpStatus.BAD_REQUEST); 
		    }
		}
	}
	@PostMapping("/update-account")
	public ResponseEntity<String> updateAccount(UserDto user){
		if(user==null || StringUtils.isEmpty(user.getUsername())) {
			return new ResponseEntity<>("Username trống.", HttpStatus.BAD_REQUEST);
		}else {
			User existedUser = userRepository.findByUsername(user.getUsername());
			
		    if (existedUser == null) {
		    	return new ResponseEntity<>("User không tồn tại",HttpStatus.CREATED);
		    }else if(existedUser.getPassword().equals(passwordEncoder.encode(user.getPassword()))){
		    	return new ResponseEntity<>("Tài khoản hoặc mật khẩu sai.",HttpStatus.BAD_REQUEST); 
		    	
		    }
		    else {
		    	existedUser = Factory.getUserInstant();
		    	existedUser.setUsername(user.getUpdateUser().getUsername());
		    	existedUser.setRole(user.getUpdateUser().getRole());
		    	existedUser.setPassword(passwordEncoder.encode(user.getUpdateUser().getPassword()));
		      userRepository.save(existedUser);
		    	return  new ResponseEntity<>("Tài khoản đã tồn tại.",HttpStatus.BAD_REQUEST); 
		    }
		}
		
	}
	
}

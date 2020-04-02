package nhathuoclankha.auth.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nhathuoclankha.auth.dto.JwtRequest;
import nhathuoclankha.auth.dto.JwtResponse;
import nhathuoclankha.auth.model.User;
import nhathuoclankha.auth.model.UserDetailCustom;
import nhathuoclankha.auth.repository.UserRepository;

@Service
public class AuthenServiceImpl implements AuthenService {
	
	@Autowired private UserRepository userRepository;
	
	@Override
	public JwtResponse authen(JwtRequest jwtRequest) {
		if(jwtRequest!=null) {
			if(jwtRequest.getUsername().equals("lankha") && jwtRequest.getPassword().equals("1")) {
				JwtResponse response = new JwtResponse();
				response.setToken("tokenFromServer");
				response.setRefresh("refresh");
				response.setRole("ADMIN");
				return response;
			}
		}
		
		
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailCustom(user);
	}

  @Override
  public UserDetails loadUserById(Long userId) {
 // Kiểm tra xem user có tồn tại trong database không?
    Optional<User> user = userRepository.findById(userId);
    if(user.isPresent()) {
      return new UserDetailCustom(user.get());
    }
    throw new UsernameNotFoundException(userId+"");
  }
}

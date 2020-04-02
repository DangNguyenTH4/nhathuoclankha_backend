package nhathuoclankha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhathuoclankha.auth.dto.JwtRequest;
import nhathuoclankha.auth.dto.JwtResponse;
import nhathuoclankha.auth.model.UserDetailCustom;
import nhathuoclankha.auth.service.AuthenService;
import nhathuoclankha.auth.service.JwtTokenProvider;
import nhathuoclankha.auth.utils.JwtTokenUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AuthenService authenService;
  @Autowired
  private JwtTokenProvider tokenProvider;

  @Autowired
  JwtTokenUtil jwtTokenUtil;

  @PostMapping
  public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) {
    // return authenService.authen(jwtRequest);
    // Xác thực từ username và password.
    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            jwtRequest.getUsername(), jwtRequest.getPassword()));

    // Nếu không xảy ra exception tức là thông tin hợp lệ
    // Set thông tin authentication vào Security Context
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Trả về jwt cho người dùng.
    UserDetailCustom user = (UserDetailCustom) authentication.getPrincipal();
    String jwt = jwtTokenUtil.generateToken(user);
    return new JwtResponse(jwt,user.getRole(),user.getUsername());
  }

  @PostMapping("/auth/login")
  public String getToken() {
    System.out.println("Login Call api");
    return "123123weqwDsdagiof@3123";
  }

  @PostMapping("/v2")
  public ResponseEntity<JwtResponse> authenticateV2(@RequestBody JwtRequest jwtRequest)
      throws Exception {
    authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    final UserDetails userDetails = authenService.loadUserByUsername(jwtRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }

}

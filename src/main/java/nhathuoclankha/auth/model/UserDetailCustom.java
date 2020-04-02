package nhathuoclankha.auth.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailCustom implements UserDetails {
  /**
  * 
  */
  private static final long serialVersionUID = -3212134L;
  private User user;


  public String getRole() {
    return user.getRole();
  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO implement role
    // Một người chỉ có một role
    return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO implement
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO implement
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO implement
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO implement
    return true;
  }

}

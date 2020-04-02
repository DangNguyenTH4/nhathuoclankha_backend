package nhathuoclankha.auth.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse implements Serializable {
  /**
  * 
  */
  private static final long serialVersionUID = -8091879091924046844L;
  private String token;
  private String refresh;
  private String role;
  private String name;

  public JwtResponse(String jwt) {
    this.token = jwt;
  }
  public JwtResponse(String jwt,String role,String name) {
    this.token=jwt;
    this.role=role;
    this.name = name;
  }


}

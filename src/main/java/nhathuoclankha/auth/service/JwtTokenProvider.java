package nhathuoclankha.auth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.auth.model.UserDetailCustom;

@Component
@Slf4j
public class JwtTokenProvider {
	
	@Value("${jwt.secretkey}")
	private String JWT_SECRET;

	  //Thời gian có hiệu lực của chuỗi jwt
	@Value("${jwt.expiretime}")
    private String JWT_EXPIRATION ;

    // Tạo ra jwt từ thông tin user
  public String generateToken(UserDetailCustom userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + Long.parseLong(JWT_EXPIRATION));
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                   .setSubject(Long.toString(userDetails.getUser().getId()))
                   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                   .compact();
    }
    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject());
    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

}

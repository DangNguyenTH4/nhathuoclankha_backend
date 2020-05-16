package nhathuoclankha.controller.error;

import nhathuoclankha.auth.dto.JwtResponse;
import nhathuoclankha.exceptions.AuthorizationException;
import nhathuoclankha.exceptions.BadRequestException;
import nhathuoclankha.exceptions.NotSupportAnyMoreException;
import nhathuoclankha.exceptions.OverExistingQuantityEception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebErrorController {
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> runtimeHandler(RuntimeException r) {
    return new ResponseEntity<>(r.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(OverExistingQuantityEception.class)
  public ResponseEntity<String> overExistingHandler(OverExistingQuantityEception ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<String> badRequestHandler(BadRequestException bre) {
    return new ResponseEntity<String>(bre.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AuthorizationException.class)
  public ResponseEntity<JwtResponse> authicatationFail(AuthorizationException auex) {
    System.out.println("Authenticate exception");
    return new ResponseEntity<JwtResponse>(new JwtResponse(), HttpStatus.UNAUTHORIZED);
  }
  @ExceptionHandler(NotSupportAnyMoreException.class)
  public ResponseEntity<String> notSupportAnymore(NotSupportAnyMoreException ex){
	  
	  return new ResponseEntity<>(ex.getMessage(),HttpStatus.METHOD_NOT_ALLOWED);
  }
}

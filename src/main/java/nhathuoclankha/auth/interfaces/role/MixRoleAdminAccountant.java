package nhathuoclankha.auth.interfaces.role;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('ROLE_ADMIN')" + " || hasRole('ROLE_ACCOUNTANT')")
public @interface MixRoleAdminAccountant {

}

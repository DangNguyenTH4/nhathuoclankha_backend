package nhathuoclankha.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nhathuoclankha.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	Optional<User> findById(Long userId);
}

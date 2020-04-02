package nhathuoclankha.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhathuoclankha.model.Medicine;
@Repository
public interface MedicineRepository  extends JpaRepository<Medicine, Integer>{
//	@Query(value = "select * from medicine where code = ?",nativeQuery = true)
	List<Medicine> findByCode(String code);
	
	List<Medicine> findAllByOrderByMedicineName();
}

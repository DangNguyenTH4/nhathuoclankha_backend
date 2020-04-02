package nhathuoclankha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nhathuoclankha.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Company findByCompanyName(String companyName);
	Optional<Company> findById(Integer id);
}

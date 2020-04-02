package nhathuoclankha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nhathuoclankha.model.Price;
@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>{
	

}

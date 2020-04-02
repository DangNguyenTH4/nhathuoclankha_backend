package nhathuoclankha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nhathuoclankha.model.ImportOrder;

@Repository
public interface ImportOrderRepository extends JpaRepository<ImportOrder, Integer> {



}

package nhathuoclankha.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhathuoclankha.model.Customer;
import nhathuoclankha.model.SellOrder;
@Repository
public interface SellOrderRepository extends JpaRepository<SellOrder, Integer>{

	List<SellOrder> findByCustomer(Customer cus);
	List<SellOrder> findByCustomerOrderByTimeDesc(Customer cus);
	List<SellOrder> findByTimeBetween(Instant fromDate,Instant toDate);
	List<SellOrder> findBySellerAndTimeBetween(String staffName,Instant fromDate,Instant toDate);
	Optional<SellOrder> findById(Integer id);
//	@Query("select * from sellorder where  time between ?1 and ?2")
//	List<SellOrder> findSellOrderBetweenDays(String from,String to);
}

package nhathuoclankha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhathuoclankha.composite.SellOrderDetailKey;
import nhathuoclankha.model.SellOrder;
import nhathuoclankha.model.SellOrderDetail;
@Repository
public interface SellOrderDetailRepository extends JpaRepository<SellOrderDetail,SellOrderDetailKey>{
	List<SellOrderDetail> findBySellorderInOrderByTimeDesc(List<SellOrder> list);
//	@Query("select * from sell_order_detail where ")
//	List<SellOrderDetail> findDetailBetweenDays(String from, String to);
//	
}

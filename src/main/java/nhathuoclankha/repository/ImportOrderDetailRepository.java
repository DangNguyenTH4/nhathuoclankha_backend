package nhathuoclankha.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhathuoclankha.composite.ImportOrderDetaiKey;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.model.ImportOrderDetail;
import nhathuoclankha.utils.QueryString;

@Repository
public interface ImportOrderDetailRepository extends JpaRepository<ImportOrderDetail, ImportOrderDetaiKey>{

  List<ImportOrderDetail> findByImportOrder(ImportOrder importOrder);
  @Query(value = QueryString.FINDBY_IMPORTORDER_ORDER_BY_MEDICINE ,nativeQuery = true)
  List<ImportOrderDetail> findByImportOrderByOrderByMedicineCode(Integer importOrderId);
}

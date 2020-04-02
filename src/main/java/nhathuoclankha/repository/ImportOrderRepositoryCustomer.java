package nhathuoclankha.repository;

import java.time.Instant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.utils.QueryString;

@Repository
public class ImportOrderRepositoryCustomer {
  /*
  * Query
  */
 @Autowired
 private EntityManager entityManager;
  public List<ImportOrder> findImportOrderBetween(Instant fromDate, Instant toDate){
    @SuppressWarnings("unchecked")
    TypedQuery<ImportOrder> tq = (TypedQuery<ImportOrder>) entityManager
        .createNativeQuery(QueryString.GET_IMPORT_BETWEEN_DATE, ImportOrder.class)
        .setParameter(1, fromDate).setParameter(2, toDate);
   
//    @SuppressWarnings("unchecked")
//    List<ImportOrder> list = (List<ImportOrder>) entityManager.createNativeQuery(QueryString.GET_IMPORT_BETWEEN_DATE).setParameter(1, fromDate).setParameter(2, toDate).getResultList();
    List<ImportOrder> list = tq.getResultList();
    return list;
  }
}

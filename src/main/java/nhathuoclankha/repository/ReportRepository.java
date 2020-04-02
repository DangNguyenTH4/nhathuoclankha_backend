package nhathuoclankha.repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import nhathuoclankha.dto.ReportDto;
import nhathuoclankha.model.Report;

@Repository
public class ReportRepository {
	/**
	 * Query
	 */
	@Autowired
	private EntityManager entityManager;

	public List<Report> getListReport(Instant fromDate, Instant toDate) {
		String query = "select m.code,m.quantity_exsiting as soluongton,sum(sod.amount) as SoluongBan from nhathuoc.sell_order_detail sod "
				+ "inner join nhathuoc.sellorder so on so.id=sod.sell_order_id "
				+ "inner join nhathuoc.medicine m on m.id=sod.medicine_id "
				+ "where so.time is not null and so.time between ?1 and ?2 group by m.code,m.quantity_exsiting;";
		@SuppressWarnings("unchecked")
//		List<Object[]> result = entityManager.createNativeQuery(query).getResultList();
		List<Object[]> result = entityManager.createNativeQuery(query).setParameter(1, fromDate).setParameter(2, toDate)
				.getResultList();
		List<Report> report = toListEntity2(result);

		return report;
	}

	private Report toEntity2(Object[] obj) {
		if (obj == null) {
			return null;
		}
		Report r = new Report();
		r.setMedicineCode(obj[0].toString());
		r.setExsitingQuantity(Integer.parseInt(obj[1].toString()));
		r.setBoughtQuanity(Integer.parseInt(obj[2].toString()));
		return r;
	}

	private List<Report> toListEntity2(List<Object[]> listObj) {
		List<Report> result = null;
		result = listObj.stream().map(this::toEntity2).collect(Collectors.toList());
		return result;
	}

}

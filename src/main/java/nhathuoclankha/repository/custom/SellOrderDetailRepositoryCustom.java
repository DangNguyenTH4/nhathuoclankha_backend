package nhathuoclankha.repository.custom;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import nhathuoclankha.dto.InvoiceDto;
import nhathuoclankha.model.Report;
import nhathuoclankha.utils.QueryString;

@Repository
public class SellOrderDetailRepositoryCustom {
	@Autowired
	private EntityManager entityManager;

	public List<InvoiceDto> getInvoiceDto(int sellOrderId) {
		@SuppressWarnings("unchecked")
		List<Object[]> result1 = entityManager.createNativeQuery(QueryString.SELECE_INVOICE_DTO)
				.setParameter(1, sellOrderId).getResultList();
		List<InvoiceDto> result = toListEntity2(result1);

		return result;
	}

	private InvoiceDto fromObjectToDto(Object[] obj) {
		InvoiceDto idto = new InvoiceDto();
		if (obj[0] != null)
			idto.setProductName(obj[0].toString());
		if (obj[1] != null)
			idto.setUnitPrice(Long.parseLong(obj[1].toString()));
		if (obj[2] != null)
			idto.setAmount(Integer.parseInt(obj[2].toString()));
		if (obj[3] != null)
			idto.setUnit(obj[3].toString());
		if (obj[4] != null)
			idto.setAddMore(Long.parseLong(obj[4].toString()));

		return idto;
	}

	private List<InvoiceDto> toListEntity2(List<Object[]> listObj) {
		List<InvoiceDto> result = null;
		result = listObj.stream().map(this::fromObjectToDto).collect(Collectors.toList());
		return result;
	}
}

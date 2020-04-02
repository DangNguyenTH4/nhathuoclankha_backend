package nhathuoclankha.service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhathuoclankha.dto.ReportDto;
import nhathuoclankha.mapper.ReportMapper;
import nhathuoclankha.model.Report;
import nhathuoclankha.model.SellOrderDetail;
import nhathuoclankha.repository.ReportRepository;
import nhathuoclankha.repository.SellOrderDetailRepository;
import nhathuoclankha.utils.DateUtils;

@Service
public class ReportService {
	@Autowired private SellOrderDetailRepository sellOrderDetailRepository;
	@Autowired private ReportRepository reportRepository;
	@Autowired private ReportMapper reportMapper;
	
	
	/**
	 * getReport.
	 * @param fromDate DateTimeFormatter.ISO_INSTANT
	 * @param toDate DateTimeFormatter.ISO_INSTANT
	 * @return
	 */
	public List<ReportDto> getReport(String fromDate, String toDate) {
		Instant from = DateUtils.getInstantDateQuery(fromDate);
		Instant to = DateUtils.getInstantDateQuery(toDate);
		List<Report> list = reportRepository.getListReport(from, to);
		List<ReportDto> result = reportMapper.toListDto(list);
		return result;
	}
	
}

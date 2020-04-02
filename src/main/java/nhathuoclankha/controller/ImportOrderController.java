package nhathuoclankha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhathuoclankha.dto.ImportOrderDto;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.repository.ImportOrderRepository;
import nhathuoclankha.service.ImportOrderService;

@RestController
@RequestMapping("/import-medicine")
public class ImportOrderController {
	@Autowired private ImportOrderRepository importOrderRepository;
	@Autowired private ImportOrderService importOrderService;
	@GetMapping("count")
	public  Long getimport() {
		return importOrderRepository.count();
	}
	@PostMapping
	public ImportOrderDto importOrder(@RequestBody ImportOrderDto importOrderDto) {
		ImportOrderDto dto = importOrderService.importOrder(importOrderDto);
		return dto;
	}
	
}

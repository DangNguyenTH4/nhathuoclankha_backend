package nhathuoclankha.dto;

import java.time.Instant;

import nhathuoclankha.composite.ImportOrderDetaiKey;

public class ImportOrderDetailDto {
	private ImportOrderDetaiKey importOrderDetailKey;
	private Instant dateImport;
	private int amount;
	public ImportOrderDetaiKey getImportOrderDetailKey() {
		return importOrderDetailKey;
	}
	public void setImportOrderDetailKey(ImportOrderDetaiKey importOrderDetailKey) {
		this.importOrderDetailKey = importOrderDetailKey;
	}
	public Instant getDateImport() {
		return dateImport;
	}
	public void setDateImport(Instant dateImport) {
		this.dateImport = dateImport;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

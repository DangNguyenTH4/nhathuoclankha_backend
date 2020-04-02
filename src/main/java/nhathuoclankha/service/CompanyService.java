package nhathuoclankha.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhathuoclankha.exceptions.CreateNewException;
import nhathuoclankha.model.Company;
import nhathuoclankha.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired private CompanyRepository companyReposioty;
	
	public Company createOne(Company company) {
		Company temp = companyReposioty.findByCompanyName(company.getCompanyName());
		
		if(temp!=null) {
			throw new CreateNewException("Công ty đã có trong danh sách!");
		}
		company = companyReposioty.save(company);
		return company;
	}
	public Company findById(int id) {
		Optional<Company> com = companyReposioty.findById(id);
		if(!com.isPresent()) {
			return null;
		}
		return com.get();
	}
	public Company findByName(String name) {
		Company com = companyReposioty.findByCompanyName(name);
		return com;
	}
}

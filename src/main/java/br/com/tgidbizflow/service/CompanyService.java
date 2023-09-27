package br.com.tgidbizflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgidbizflow.model.Company;
import br.com.tgidbizflow.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private final CompanyRepository companyRepository;
	
	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	public Company getCompanyById(Long companyId) {
		return companyRepository.findById(companyId).orElse(null);
	}
	
	public void deposit(Long companyId, Double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("O valor do depósito deve ser um valor positivo.");
		}
		
		Company company = getCompanyById(companyId);
		double newCompanyBalance = company.getCompanyBalance() + amount;
		company.setCompanyBalance(newCompanyBalance);
		
		companyRepository.save(company);
	}
	
	public void withdraw(Long companyId, Double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser um valor positivo.");
		}
		
		Company company = getCompanyById(companyId);
		
		if (amount > company.getCompanyBalance()) {
			throw new IllegalArgumentException("O saldo é insuficiente para realizar o saque.");
		}
		
		double newCompanyBalance = company.getCompanyBalance() - amount;
		company.setCompanyBalance(newCompanyBalance);
		
		companyRepository.save(company);
	}
	

}

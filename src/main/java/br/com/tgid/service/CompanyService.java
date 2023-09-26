package br.com.tgid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgid.model.Company;

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
	
	public void deposit(Company company, Double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("O valor do depósito deve ser um valor positivo.");
		}
		
		double newCompanyBalance = company.getCompanyBalance() + amount;
		companyRepository.save(company);
	}
	
	public void withdraw(Company company, Double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser um valor positivo.");
		}
		
		if(amount > company.getCompanyBalance()) {
			throw new IllegalArgumentException("O saldo é insuficiente para realizar o saque.")
		}
		
		double newCompanyBalance = company.getCompanyBalance() + amount;
		
		company.setCompanyBalance(newCompanyBalance);
		
		companyRepository.save(company);
	}
	
}

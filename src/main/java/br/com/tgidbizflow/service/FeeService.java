package br.com.tgidbizflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgidbizflow.model.Company;
import br.com.tgidbizflow.model.Fee;
import br.com.tgidbizflow.repository.CompanyRepository;

@Service
public class FeeService {
	private final CompanyRepository companyRepository;

	@Autowired
	public FeeService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public void applyFeesToTransaction(Company company, Double transactionAmount) {
		List<Fee> fees = company.getFees();

		for (Fee fee : fees) {
			Double feeAmount = fee.getAmount();
			transactionAmount -= feeAmount;
		}
		company.setCompanyBalance(company.getCompanyBalance() + transactionAmount);
		companyRepository.save(company);
	}
}

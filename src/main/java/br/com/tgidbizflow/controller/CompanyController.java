package br.com.tgidbizflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.tgidbizflow.model.Company;
import br.com.tgidbizflow.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping("/{companyId}")
	public Company getCompanyById(@PathVariable Long companyId) {
		return companyService.getCompanyById(companyId);
	}

	@PostMapping("/{companyId}/deposit")
	public void deposit(@PathVariable Long companyId, @RequestParam Double amount) {
	    companyService.deposit(companyId, amount);
	}

	@PostMapping("/{companyId}/withdraw")
	public void withdraw(@PathVariable Long companyId, @RequestParam Double amount) {
	    companyService.withdraw(companyId, amount);
	}
}

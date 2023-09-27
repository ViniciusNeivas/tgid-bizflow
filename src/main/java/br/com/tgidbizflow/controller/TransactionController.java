package br.com.tgidbizflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgidbizflow.model.Company;
import br.com.tgidbizflow.model.Customer;
import br.com.tgidbizflow.service.CompanyService;
import br.com.tgidbizflow.service.CustomerService;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final CustomerService customerService;
	private final CompanyService companyService;
	
	@Autowired
	public TransactionController(CustomerService customerService, CompanyService companyService) {
		this.customerService = customerService;
		this.companyService = companyService;
	}
	
	@PostMapping("deposit/customer/{customerId}")
	public void depositToCustomer(@PathVariable Long customerId, @RequestBody Double amount) {
		Customer customer = customerService.getCustomerById(customerId);
		customerService.deposit(customer, amount);
	}
	
	@PostMapping("/withdraw/customer/{customerId}")
	public void withdrawFromCustomer(@PathVariable Long customerId, @RequestBody Double amount) {
		Customer customer = customerService.getCustomerById(customerId);
		customerService.withdraw(customer, amount);
	}
	
	@PostMapping("/deposit/company/{companyId}")
	public void depositToCompany(@PathVariable Long companyId, @RequestBody Double amount) {
	    companyService.deposit(companyId, amount);
	}

	@PostMapping("/withdraw/company/{companyId}")
	public void withdrawFromCompany(@PathVariable Long companyId, @RequestBody Double amount){
	    companyService.withdraw(companyId, amount);
	}

}

package br.com.tgidbizflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tgidbizflow.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCpf(String cpf);
	Customer findByCustomerName(String customerName);
	List<Customer> findAllByOrderByCustomerNameAsc();
	
}

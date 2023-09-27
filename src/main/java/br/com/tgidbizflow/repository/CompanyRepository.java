package br.com.tgidbizflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.tgidbizflow.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByCnpj(String cnpj);
	Company findByName(String name);
	List<Company> findAllByOrderByCompanyNameAsc();
	List<Company> findByFeesName(String feeName);
}

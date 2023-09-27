package br.com.tgidbizflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;

	@Pattern(regexp = "^(?!000\\.000\\.000-00|111\\.111\\.111-11|222\\.222\\.222-22|333\\.333\\.333-33|444\\.444\\.444-44|555\\.555\\.555-55|666\\.666\\.666-66|777\\.777\\.777-77|888\\.888\\.888-88|999\\.999\\.999-99|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
	private String cpf;
	private double customerBalance;

	public Customer() {

	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}

}

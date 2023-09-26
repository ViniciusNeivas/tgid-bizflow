package br.com.tgid.service;

import br.com.tgid.model.Customer;
import br.com.tgid.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public void deposit(Customer customer, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        double newCustomerBalance = customer.getCustomerBalance() + amount;       
        customer.setBalance(newBalance);
        customerRepository.save(customer);
    }

    public void withdraw(Customer customer, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        
        if (amount > customer.getCustomerBalance()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }

        double newBalance = customer.getCustomerBalance() - amount;
        customer.setCustomerBalance(newBalance);
        customerRepository.save(customer);
    }
}

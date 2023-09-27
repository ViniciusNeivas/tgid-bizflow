package br.com.tgidbizflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgidbizflow.model.Customer;
import br.com.tgidbizflow.repository.CustomerRepository;

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

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public boolean deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }

    public void deposit(Customer customer, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }

        double newCustomerBalance = customer.getCustomerBalance() + amount;
        customer.setCustomerBalance(newCustomerBalance);
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

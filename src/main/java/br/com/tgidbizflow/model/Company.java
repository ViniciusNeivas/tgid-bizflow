package br.com.tgidbizflow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import jakarta.validation.constraints.Pattern;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;

    @Pattern(regexp = "^(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2})|(\\d{14})$", message = "CNPJ inválido")
    private String cnpj;
   
    private double companyBalance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Fee> fees;

    public Company() {
       
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getCompanyBalance() {
        return companyBalance;
    }

    public void setCompanyBalance(double companyBalance) {
        this.companyBalance = companyBalance;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }
    
    public void applyFees() {
        double totalFees = fees.stream()
                .mapToDouble(Fee::getAmount)
                .sum();
        double newCompanyBalance = companyBalance - totalFees;
        setCompanyBalance(newCompanyBalance);
    }
}

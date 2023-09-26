package br.com.tgid.model;

import java.util.List;

public class Company {
	private Long companyId;
	private String companyName;
	private String cnpj;
	private double companyBalance;
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
	
	
}

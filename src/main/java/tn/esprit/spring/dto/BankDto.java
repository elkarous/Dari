package tn.esprit.spring.dto;

import java.util.Set;




public class BankDto {
	
	private Long id;
	private String name;
	private String description; 
    private double interestRate;
	private Set<BankOffersDto> bankOffer;
	
	//Getters,Setters,Constructors
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Set<BankOffersDto> getBankOffer() {
		return bankOffer;
	}

	public void setBankOffer(Set<BankOffersDto> bankOffer) {
		this.bankOffer = bankOffer;
	}

	public BankDto(Long id, String name, String description, double interestRate, Set<BankOffersDto> bankOffer) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.interestRate = interestRate;
		this.bankOffer = bankOffer;
	}

	public BankDto() {
		super();
	
	}


	
	


}

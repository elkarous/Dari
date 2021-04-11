package tn.esprit.spring.dto;

import java.util.List;
import java.util.Set;




public class BankDto {
	
	private Long id;
	private String name;
	private String description; 
    private double interestRate;
	private List<BankOffersDto> bankOffer;
	
	//Getters,Setters,Constructors
	
	public List<BankOffersDto> getBankOffer() {
		return bankOffer;
	}

	public void setBankOffer(List<BankOffersDto> bankOffer) {
		this.bankOffer = bankOffer;
	}

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

	

	public BankDto(Long id, String name, String description, double interestRate, List<BankOffersDto> bankOffer) {
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

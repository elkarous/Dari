package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "T_BANK")
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBank")
	private Long id;
	
	@NotNull
	@Column(name = "nameBank")
	private String name;
	
	@NotNull
	@Column(name = "descriptionBank")
	private String description; 
	
	
	@NotNull
	@Min(value =1)
	@Min(value =50)
	@Column(name = "interest_rate")
    private double interestRate;
	
	public double getInterestRate() {
		return interestRate;
	}


	public Bank(@NotNull String name, @NotNull String description, @NotNull @Min(1) @Min(50) double interestRate,
			Set<BankOffers> bankOffer) {
		super();
		this.name = name;
		this.description = description;
		this.interestRate = interestRate;
		this.bankOffer = bankOffer;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy="bank")
	private Set<BankOffers> bankOffer;


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


	public Set<BankOffers> getBankOffer() {
		return bankOffer;
	}


	public void setBankOffer(Set<BankOffers> bankOffer) {
		this.bankOffer = bankOffer;
	}


	public Bank() {
		super();
	}


	public Bank(Long id, String name, String description, Set<BankOffers> bankOffer) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.bankOffer = bankOffer;
	}
	

	
	
	
}

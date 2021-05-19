package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	
	
	
	@OneToOne
 @JoinColumn(name="logo")
	private FileDB logo; 
	
	public FileDB getLogo() {
		return logo;
	}

	public void setLogo(FileDB logo) {
		this.logo = logo;
	}

	public Bank(Long id, @NotNull String name, @NotNull String description, FileDB logo,
			@NotNull @Min(1) @Min(50) double interestRate, List<BankOffers> bankOffer) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.interestRate = interestRate;
		this.bankOffer = bankOffer;
	}







	@NotNull
	@Min(value =1)
	@Min(value =50)
	@Column(name = "interest_rate")
    private double interestRate;
	
	 @OneToMany(
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )

	private List<BankOffers> bankOffer= new ArrayList<>();
	
	//getters ,setters,constructors
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@JsonManagedReference
	public List<BankOffers> getBankOffer() {
		return bankOffer;
	}


	public void setBankOffer(List<BankOffers> bankOffer) {
		this.bankOffer = bankOffer;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
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


	

	public Bank() {
		super();
	}





	public Bank(Long id, @NotNull String name, @NotNull String description,
			@NotNull @Min(1) @Min(50) double interestRate, List<BankOffers> bankOffer) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.interestRate = interestRate;
		this.bankOffer = bankOffer;
	}


	

	
	
	
}

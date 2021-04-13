package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "T_BANK_OFFERS")
public class BankOffers implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBankOffer")
	private Long idBankOffer;
	
	@NotNull
	@Column(name = "nameBankOffer")
	private String nameBankoffer;
	
	@NotNull
	@Column(name = "descriptionBankOffer")
	private String descriptionBankOffer;
	
	@NotNull
	@Column(name = "Grace_period")
	private String gracePeriod;
	
	@NotNull
	@Column(name = "Self-financing")
	private int selfFinancing;
	
	@NotNull
	@Column(name = "Max_Credit")
	private double maxCredit;
	
	@Min(value=1)
	@Column(name = "Period")
    private int period;

	
	@ManyToOne( cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="bank_id")
	Bank bank;

				

	//getters ,setters,constructors


	public BankOffers() {
		super();
	}



	public Long getIdBankOffer() {
		return idBankOffer;
	}

	public void setIdBankOffer(Long idBankOffer) {
		this.idBankOffer = idBankOffer;
	}

	public String getNameBankoffer() {
		return nameBankoffer;
	}

	public void setNameBankoffer(String nameBankoffer) {
		this.nameBankoffer = nameBankoffer;
	}

	public String getDescriptionBankOffer() {
		return descriptionBankOffer;
	}

	

	public String getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(String gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public int getSelfFinancing() {
		return selfFinancing;
	}

	public void setSelfFinancing(int selfFinancing) {
		this.selfFinancing = selfFinancing;
	}

	public double getMaxCredit() {
		return maxCredit;
	}

	public void setMaxCredit(double maxCredit) {
		this.maxCredit = maxCredit;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setDescriptionBankOffer(String descriptionBankOffer) {
		this.descriptionBankOffer = descriptionBankOffer;
	}


	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}



	public BankOffers(Long idBankOffer, @NotNull String nameBankoffer, @NotNull String descriptionBankOffer,
			@NotNull String gracePeriod, @NotNull int selfFinancing, @NotNull double maxCredit, @Min(1) int period,
			Bank bank) {
		super();
		this.idBankOffer = idBankOffer;
		this.nameBankoffer = nameBankoffer;
		this.descriptionBankOffer = descriptionBankOffer;
		this.gracePeriod = gracePeriod;
		this.selfFinancing = selfFinancing;
		this.maxCredit = maxCredit;
		this.period = period;
		this.bank = bank;
	}
	
	
	
	
	
}

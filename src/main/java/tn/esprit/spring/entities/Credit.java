package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name="T_CREDIT")
public class Credit implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "CreditId")
	private Long creditId ;

	@Min(value =1)
	@Min(value =50)
	@Column(name = "interest_rate")
    private double interestRate; 
	@Min(value = 1000)
	@Column(name = "amount")
    private double amount;
	
	@Min(value =1)
	@Min(value =50)
	@Column(name = "Period")
    private int period;

	@Column(name = "monthlyPayment")
    private double  monthlyPayment;
	
	//getters ,setters,constructors
	
	public Credit(@Min(1) @Min(50) double interestRate, @Min(1000) double amount, @Min(1) @Min(50) int period,
			double monthlyPayment) {
		super();
		this.interestRate = interestRate;
		this.amount = amount;
		this.period = period;
		this.monthlyPayment = monthlyPayment;
	}

	
	
	
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public Credit() {
		super();
		
	}
	
	public Long getCreditId() {
		return creditId;
	}
	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
}

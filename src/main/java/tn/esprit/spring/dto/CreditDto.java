package tn.esprit.spring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;



public class CreditDto implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private double amount;
    private int period;
	private double  salary;
	private double  monthlyPayment;
	private Long creditId ;
    private double interestRate; 
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
    
	
	
	public CreditDto(double amount, int period, double salary, double monthlyPayment, Long creditId,
			double interestRate) {
		super();
		this.amount = amount;
		this.period = period;
		this.salary = salary;
		this.monthlyPayment = monthlyPayment;
		this.creditId = creditId;
		this.interestRate = interestRate;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public CreditDto() {
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

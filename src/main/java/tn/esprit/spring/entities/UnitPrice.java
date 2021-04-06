package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "T_PriceUnit")
public class UnitPrice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Postal_Code")
	private int  postalCode;
	@Column(name = "MaxUnitPrice")
	private int maxunitprice;
	@Column(name = "MinUnitPrice")
	private int minunitprice;
	
	public UnitPrice() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public int getMaxunitprice() {
		return maxunitprice;
	}

	public void setMaxunitprice(int maxunitprice) {
		this.maxunitprice = maxunitprice;
	}

	public int getMinunitprice() {
		return minunitprice;
	}

	public void setMinunitprice(int minunitprice) {
		this.minunitprice = minunitprice;
	}

	public UnitPrice(int postalCode, int maxunitprice, int minunitprice) {
		super();
		this.postalCode = postalCode;
		this.maxunitprice = maxunitprice;
		this.minunitprice = minunitprice;
	}
	
	
}

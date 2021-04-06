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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_Adress")
public class Adress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdress;
	
	@NotNull
	@Column(name = "Postal_Code")
	private int  postalCode;
	
	public Adress(@NotNull int postalCode, @NotNull String street, @NotNull String city, @NotNull String gouvernorat,
			Set<House> houses) {
		super();
		this.postalCode = postalCode;
		this.street = street;
		this.city = city;
		this.gouvernorat = gouvernorat;
		this.houses = houses;
	}

	@NotNull
	@Column(name = "Street")
	private String  street ;
	@NotNull
	@Column(name = "City")
	private String  city;
	
	@NotNull
	@Column(name = "Gouvernorat")
	private String  gouvernorat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="adress")
	private Set<House> houses;

	public Long getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
	}

	

	public Adress(int postalCode, String street, String city, String gouvernorat) {
		super();
		this.postalCode = postalCode;
		this.street = street;
		this.city = city;
		this.gouvernorat = gouvernorat;
		
	}

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public Adress() {
		super();
	
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	
	
}

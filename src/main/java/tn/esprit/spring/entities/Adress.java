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
	@Column(name = "municipal")
	private String  municipal;
	


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

	public String getMunicipal() {
		return municipal;
	}

	public void setMunicipal(String municipal) {
		this.municipal = municipal;
	}

	public Adress(@NotNull String municipal, @NotNull String street, @NotNull String city, @NotNull String gouvernorat,
			Set<House> houses) {
		super();
		this.municipal = municipal;
		this.street = street;
		this.city = city;
		this.gouvernorat = gouvernorat;
		this.houses = houses;
	}

	

	
	
}

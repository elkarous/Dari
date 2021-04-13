package tn.esprit.spring.dto;


import java.util.Set;






public class AdressDto  {
	private Long idAdress;
	private String  municipal;
	private String  street ;
	private String  city;
	private String  gouvernorat;
	private Set<HouseDto> houses;
	
	//getters ,setters,constructors
	
	public Long getIdAdress() {
		return idAdress;
	}
	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
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
	public Set<HouseDto> getHouses() {
		return houses;
	}
	public void setHouses(Set<HouseDto> houses) {
		this.houses = houses;
	}

	public AdressDto(Long idAdress, String municipal, String street, String city, String gouvernorat,
			Set<HouseDto> houses) {
		super();
		this.idAdress = idAdress;
		this.municipal = municipal;
		this.street = street;
		this.city = city;
		this.gouvernorat = gouvernorat;
		this.houses = houses;
	}
	public String getMunicipal() {
		return municipal;
	}
	public void setMunicipal(String municipal) {
		this.municipal = municipal;
	}
	public AdressDto() {
		super();
	}

	

	
	
}

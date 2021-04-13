package tn.esprit.spring.dto;

public class UnitPriceDto {
	private Long id;
	private String  municipal;
	private int maxunitprice;
	private int minunitprice;
	
	//getters,setters,constructors
	
	public Long getId() {
		return id;
	}
	public UnitPriceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnitPriceDto(Long id, String municipal, int maxunitprice, int minunitprice) {
		super();
		this.id = id;
		this.municipal = municipal;
		this.maxunitprice = maxunitprice;
		this.minunitprice = minunitprice;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMunicipal() {
		return municipal;
	}
	public void setMunicipal(String municipal) {
		this.municipal = municipal;
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
}

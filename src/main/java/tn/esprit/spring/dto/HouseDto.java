package tn.esprit.spring.dto;






public class HouseDto {
	private int IdHouse;	
	
	private AdressDto adress;
	private int area;	
	private int nbRooms;
	private int nbGarage;
	private boolean terrace;
	private boolean swimmingPool;
	private boolean garden;	
	public boolean sousSol;		
	private boolean ascenseur;
	private KindOfGood kindofgood;
	
	public enum KindOfGood {
		land ,apartment,villa,studio,workshop,warehouse
		}
	//getters ,setters,constructors
	
	public HouseDto() {
		super();
	}

	public HouseDto(int idHouse, AdressDto adress, int area, int nbRooms, int nbGarage, boolean terrace,
			boolean swimmingPool, boolean garden, boolean sousSol, boolean ascenseur, KindOfGood kindofgood) {
		super();
		IdHouse = idHouse;
		this.adress = adress;
		this.area = area;
		this.nbRooms = nbRooms;
		this.nbGarage = nbGarage;
		this.terrace = terrace;
		this.swimmingPool = swimmingPool;
		this.garden = garden;
		this.sousSol = sousSol;
		this.ascenseur = ascenseur;
		this.kindofgood = kindofgood;
	}

	public int getIdHouse() {
		return IdHouse;
	}

	public void setIdHouse(int idHouse) {
		IdHouse = idHouse;
	}

	public AdressDto getAdress() {
		return adress;
	}

	public void setAdress(AdressDto adress) {
		this.adress = adress;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	public int getNbGarage() {
		return nbGarage;
	}

	public void setNbGarage(int nbGarage) {
		this.nbGarage = nbGarage;
	}

	public boolean isTerrace() {
		return terrace;
	}

	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public boolean isSousSol() {
		return sousSol;
	}

	public void setSousSol(boolean sousSol) {
		this.sousSol = sousSol;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public KindOfGood getKindofgood() {
		return kindofgood;
	}

	public void setKindofgood(KindOfGood kindofgood) {
		this.kindofgood = kindofgood;
	}
	
	
	
}

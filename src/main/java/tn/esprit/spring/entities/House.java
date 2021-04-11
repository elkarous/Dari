package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "T_House")


public class House implements Serializable{
		private static final long serialVersionUID = 1L;
        
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int IdHouse;	
		
		@ManyToOne(cascade = CascadeType.ALL)
		 Adress adress;
		@NotNull
		@Min(value =10)
		@Column(name = "area")
		private int area;
		@Column(name = "nb_rooms")
		private int nbRooms;
		@Column(name = "nb_garage")
		private int nbGarage;
		@Column(name = "terrace")
		private boolean terrace;
		@Column(name = "swimingpool")
		private boolean swimmingPool;
		@Column(name = "garden")
		private boolean garden;	
		@Column(name = "sousol")
		public boolean sousSol;		
		@Column(name = "assensseur")
		private boolean ascenseur;
		@Column(name = "Price")
		private float price;
		@NotNull
		@Enumerated(EnumType.STRING)
		@Column(name = "Kindofgood")
		private KindOfGood kindofgood;

		
		

		
	




		public House(Adress adress, @NotNull @Min(10) int area, int nbRooms, int nbGarage, boolean terrace,
				boolean swimmingPool, boolean garden, boolean sousSol, boolean ascenseur, float price,
				@NotNull KindOfGood kindofgood) {
			super();
			this.adress = adress;
			this.area = area;
			this.nbRooms = nbRooms;
			this.nbGarage = nbGarage;
			this.terrace = terrace;
			this.swimmingPool = swimmingPool;
			this.garden = garden;
			this.sousSol = sousSol;
			this.ascenseur = ascenseur;
			this.price = price;
			this.kindofgood = kindofgood;
		}





		public int getArea() {
			return area;
		}





		public void setArea(int area) {
			this.area = area;
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





		public float getPrice() {
			return price;
		}





		public void setPrice(float price) {
			this.price = price;
		}











		public enum KindOfGood {
			land ,apartment,villa,workshop
			}
		public int getIdHouse() {
			return IdHouse;
		}





		public void setIdHouse(int idHouse) {
			IdHouse = idHouse;
		}




		public Adress getAdress() {
			return adress;
		}





		public void setAdress(Adress adress) {
			this.adress = adress;
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





		





		public House() {
			super();
		}










		
		}

package tn.esprit.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.repository.HouseRepository;
import tn.esprit.spring.repository.UnitPriceRepository;
@Service
public class EstimationServiceImp implements EstimationService{

	@Autowired
	HouseRepository houseRepository;
	@Autowired
	UnitPriceRepository unitPriceRepository;
	
	//estimation of house 
	
		@Override
		public Map<String,Float> estimation(HouseDto housedto) {
			Map<String,Float> map=new HashMap<String,Float>();
			map.put("minimum price:", priceCalculation(housedto,unitPriceRepository.getMinUnitPrice(housedto.getAdress().getMunicipal())));
			map.put("maximum price:", priceCalculation(housedto,unitPriceRepository.getMaxUnitPrice(housedto.getAdress().getMunicipal())));

			return map;
		}
		
		
		
		//estimation function
		
		public float priceCalculation(HouseDto house,float unit){
			float price=house.getArea()*unit;
			
		switch(house.getKindofgood()) {
				case apartment:
		
				price*= 1.5;
				if(house.getNbRooms()!=0) {
					price+=house.getNbRooms()*0.02;
				}
				if(house.isAscenseur()) {
					price*= 1.04;
				}
				break;
				case workshop:
					price*= 1.5;
					if(house.getNbGarage()>1) {
						price+=house.getNbGarage()*0.02;
					}
						break;
				case villa:
				
						price*= 1.5;
					if(house.getNbGarage()!=0) {
						price+=house.getNbGarage()*0.02;
					}
					if(house.getNbRooms()!=0) {
						price+=house.getNbRooms()*0.02;
					}
					if(house.isTerrace()) {
						price*= 1.02;
					}
					if(house.isSwimmingPool()) {
						price*= 1.04;
					}
					if(house.isGarden()) {
						price*= 1.03;
					}
					if(house.isAscenseur()) {
						price*= 1.04;
					}
					if(house.isSousSol()) {
						price*= 1.02;
					}
					break;
		default:
			break;
		}

			
			return price;
		}

}

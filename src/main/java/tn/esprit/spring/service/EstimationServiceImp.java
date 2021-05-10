package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.dto.UnitPriceDto;
import tn.esprit.spring.entities.UnitPrice;
import tn.esprit.spring.repository.UnitPriceRepository;

@Service
public class EstimationServiceImp implements EstimationService{

	
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
		
		@Override
		public UnitPrice getUnitpriceByMunicipal( String municipale) {
			return unitPriceRepository.findByMunicipal(municipale);
		}
		//add unit price 
		
		@Override
		public UnitPriceDto addUnitPrice(UnitPriceDto unitPriceDto) {
			
			 ModelMapper modelMapper = new ModelMapper();
			 UnitPrice	unitPrice = modelMapper.map(unitPriceDto, UnitPrice.class);
			unitPriceRepository.save(unitPrice);
			
			return	unitPriceDto;
			
		}
		//get all unitPrice
		@Override
		public List<UnitPriceDto> getAll() {
			List<UnitPriceDto> unitPriceDtoList = new ArrayList<>();
			List<UnitPrice> unitPriceList= (List<UnitPrice>) unitPriceRepository.findAll();
			for(UnitPrice unitPrice :unitPriceList) {
				
			 ModelMapper modelMapper = new ModelMapper();
			 UnitPriceDto unitPriceDto = modelMapper.map(unitPrice, UnitPriceDto.class);
			 unitPriceDtoList.add(unitPriceDto);
			}
			
			return	unitPriceDtoList;
			
		}
		
		 //delete unit price 
		
		@Override
		public void deleteUnitPrice (Long id) {
			UnitPrice unitPrice = unitPriceRepository.findById(id).get();
			unitPriceRepository.delete(unitPrice);
			
		}
		
		 //update unit price 
		
		@Override
		public UnitPriceDto updateUnitPrice(UnitPriceDto unitPriceDto) {
			UnitPrice unitPrice= 	unitPriceRepository.findById(unitPriceDto.getId()).get();
			if(unitPrice!=null)
			{ 
				ModelMapper modelMapper = new ModelMapper();
				unitPrice = modelMapper.map(unitPriceDto, UnitPrice.class);
				 unitPriceRepository.save(unitPrice);
			}
			 
			return  unitPriceDto;
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

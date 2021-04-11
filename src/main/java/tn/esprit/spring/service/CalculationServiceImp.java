package tn.esprit.spring.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.repository.CreditRepository;
import tn.esprit.spring.repository.HouseRepository;
import tn.esprit.spring.repository.UnitPriceRepository;

@Service
public class CalculationServiceImp implements CalculationService {
	@Autowired
	HouseRepository houseRepository;
	@Autowired
	UnitPriceRepository unitPriceRepository;
	@Autowired 
	CreditRepository creditRepository;
	@Autowired 
	BankService banksevice;

	
	//estimation of house 
	
	@Override
	public Map<String,Float> estimate(HouseDto housedto) {
		Map<String,Float> map=new HashMap<String,Float>();
		map.put("minimum price:", priceCalculation(housedto,unitPriceRepository.getMinUnitPrice(housedto.getAdress().getMunicipal())));
		map.put("maximum price:", priceCalculation(housedto,unitPriceRepository.getMaxUnitPrice(housedto.getAdress().getMunicipal())));

		return map;
	}
	
	//calculation of credit in all bank 
	
	@Override
	public Map< Map<String, Double>,List<BankOffersDto>> CalculeCreditByIR(CreditDto credit) {
		Map< Map<String, Double>,List<BankOffersDto>>  map= new HashMap<>();
		 Map<String, Double>m=new HashMap<>();
		for(BankDto bank:banksevice.getALLBankByIr(credit.getInterestRate())) {
			
				m.put(bank.getName() ,CalculeCredit(credit,bank.getInterestRate()));
			}
		map.put(m,banksevice.getAllOffrersByMaxCredit(credit.getAmount(),credit.getPeriod()));
		return map ;
		
	
	}
	
	//calculation of credit by bank
	
	@Override
	public CreditDto CalculeCreditByBank(CreditDto creditdto,String bankName){
		  ModelMapper modelMapper = new ModelMapper();
		  Credit credit = modelMapper.map(creditdto, Credit.class);
		credit.setMonthlyPayment(CalculeCredit(creditdto,banksevice.getBankByName(bankName).getInterestRate()));
		CreditDto creditdt = modelMapper.map(credit, CreditDto.class);
		return creditdt;
		
	}
	
	//calculation of credit  by Interest Rate
	
	@Override
	public CreditDto CalculeCredit(CreditDto creditDto){
		 ModelMapper modelMapper = new ModelMapper();
		  Credit credit = modelMapper.map(creditDto, Credit.class);
		credit.setMonthlyPayment(CalculeCredit(creditDto,credit.getInterestRate()));
		CreditDto creditdt = modelMapper.map(credit, CreditDto.class);
		return creditdt;
		
	}
	
	//calculation function
	
	public Double CalculeCredit(CreditDto credit,double interestRate ) {
		Double m=(Double) (credit.getAmount()*(interestRate/1200)/(1- (Math.pow((1+interestRate/1200),-credit.getPeriod()*12 ))));
	
	return m;
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
	


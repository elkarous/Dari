package tn.esprit.spring.service;



import java.util.HashMap;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.entities.House;
import tn.esprit.spring.repository.BankRepository;
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
	BankRepository bankRepository;
	@Autowired 
	BankService banksevice;

	
	
	@Override
	public float estimate(House house) {
		
		return priceCalculation(house);
	}
	
	@Override
	public Map<String, Double> CalculeCreditByIR(CreditDto credit) {
		Map<String, Double> map= new HashMap<String,Double>();
		for(Bank bank:banksevice.getALLBankByIr(credit.getInterestRate())) {
			map.put(bank.getName() ,CalculeCredit(credit,bank.getInterestRate()));
			}
		
		return map ;
		
	
	}
	@Override
	public CreditDto CalculeCreditByBank(CreditDto creditdto,String bankName){
		  ModelMapper modelMapper = new ModelMapper();
		  Credit credit = modelMapper.map(creditdto, Credit.class);
		credit.setMonthlyPayment(CalculeCredit(creditdto,banksevice.getBankByName(bankName).getInterestRate()));
		CreditDto creditdt = modelMapper.map(credit, CreditDto.class);
		return creditdt;
		
	}
	
	@Override
	public CreditDto CalculeCredit(CreditDto credit){
		credit.setMonthlyPayment(CalculeCredit(credit,credit.getInterestRate()));
		return credit;
		
	}
	public Double CalculeCredit(CreditDto credit,double interestRate ) {
		Double m=(Double) (credit.getAmount()*(interestRate/1200)/(1- (Math.pow((1+interestRate/1200),-credit.getPeriod()*12 ))));
	
	return m;
	}
	


	
	public float priceCalculation(House house){
		float price=house.getArea()*unitPriceRepository.getUnitPrice(house.getAdress().getPostalCode());
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
		
		return price;
	}


}
	


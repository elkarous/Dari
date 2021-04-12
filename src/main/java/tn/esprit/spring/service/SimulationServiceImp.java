package tn.esprit.spring.service;



import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.entities.Bank;

import tn.esprit.spring.repository.CreditRepository;
import tn.esprit.spring.repository.BankRepository;

@Service
public class SimulationServiceImp implements SimulationService {

	@Autowired 
	CreditRepository creditRepository;
	@Autowired 
	BankService banksevice;
	@Autowired 
   BankRepository 	bankRepository;
	
	
	
	//calculation of credit in all bank 
	
	@Override
	public Map<String, Double> CalculeCreditInAllBank(CreditDto creditdto) {
		 Map<String, Double>  map= new HashMap<>();
		for(Bank bank:bankRepository.findAll()) {
			
				map.put(bank.getName() ,CalculeCredit(creditdto.getAmount(),bank.getInterestRate(),creditdto.getPeriod()));
			}
	
		return map ;
		
	
	}
	
	//calculation of credit by bank
	
	@Override
	public Map<String,Double> CalculeCreditByBank(CreditDto creditdto,String bankName){
		Map<String,Double>  map= new HashMap<>();
		for(BankOffersDto offre:banksevice.getAllOffrersByBank(bankName)) {
			double amount=creditdto.getAmount()-(creditdto.getAmount()*offre.getSelfFinancing()/100);
		  map.put( offre.getNameBankoffer(),CalculeCredit(amount,banksevice.getBankByName(bankName).getInterestRate(),creditdto.getPeriod()));
		}
		
		return map;
		
	}
	
	
	
	//calculation of credit  by Interest Rate
	
	@Override
	public CreditDto CalculeCreditByIr(CreditDto creditDto){
	
		creditDto.setMonthlyPayment(CalculeCredit(creditDto.getAmount(),creditDto.getInterestRate(),creditDto.getPeriod()));
		
		return creditDto;
		
	}
	
	
	
	
	//calculation function
	
	public Double CalculeCredit(double amount,double interestRate ,int period ) {
	
	return amount*(interestRate/1200)/(1- (Math.pow((1+interestRate/1200),-period*12 )));
	
	}
	

	

}
	


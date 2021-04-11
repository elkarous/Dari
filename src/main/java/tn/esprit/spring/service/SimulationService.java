package tn.esprit.spring.service;




import java.util.Map;

import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.dto.CreditDto;





public interface SimulationService {



	public Map<String, Double> CalculeCreditInAllBank(CreditDto credit);


	public Map<Double, BankOffersDto> CalculeCreditByBank(CreditDto credit, String bankName);

	public CreditDto CalculeCreditByIr(CreditDto creditDto);


	public CreditDto BestChoice(CreditDto creditDto);

	

}

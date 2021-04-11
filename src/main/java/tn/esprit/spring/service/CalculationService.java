package tn.esprit.spring.service;



import java.util.List;
import java.util.Map;

import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.dto.HouseDto;




public interface CalculationService {

	Map<String, Float> estimate(HouseDto house);

	Map<Map<String, Double>, List<BankOffersDto>> CalculeCreditByIR(CreditDto credit);

	CreditDto CalculeCredit(CreditDto credit);

	CreditDto CalculeCreditByBank(CreditDto credit, String bankName);

	

}

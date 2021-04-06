package tn.esprit.spring.service;


import java.util.Map;

import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.entities.House;


public interface CalculationService {

	float estimate(House house);

	Map<String, Double> CalculeCreditByIR(CreditDto credit);

	CreditDto CalculeCredit(CreditDto credit);

	CreditDto CalculeCreditByBank(CreditDto credit, String bankName);

	

}

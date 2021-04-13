package tn.esprit.spring.service;




import java.util.Map;


import tn.esprit.spring.dto.CreditDto;





public interface SimulationService {



	public Map<String, Double> CalculeCreditInAllBank(CreditDto credit);


	public Map<String, Double> CalculeCreditByBank(CreditDto credit, String bankName);

	public CreditDto CalculeCreditByIr(CreditDto creditDto);


	public CreditDto CalculeCreditByIrSave(CreditDto creditDto);


	

	

}

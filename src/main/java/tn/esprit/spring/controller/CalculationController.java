package tn.esprit.spring.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.service.CalculationService;
import tn.esprit.spring.service.EmailService;


@RestController
@RequestMapping("/calculation")
public class CalculationController {
	@Autowired
    CalculationService calculationservice ;
	@Autowired
	EmailService emailsevice;
	
	//simulation of credit  by Interest Rate
	
	@PostMapping(path="/simulation")
	@ResponseBody
	public CreditDto calcule( @RequestBody CreditDto creditDto) {
		// emailsevice.sendSimpleMessage("elkarous.elkilani@gmail.com", "simulation", credit.toString());
		
		return calculationservice.CalculeCredit(creditDto);
		
	}
	
	//simulation of credit in all bank
	
	@PostMapping(path="/simulationByIr")
	@ResponseBody
	public Map< Map<String, Double>,List<BankOffersDto>> calculeByIr( @RequestBody CreditDto credit) {
		return calculationservice.CalculeCreditByIR(credit) ;
		
	}
	
	//simulation of credit by bank
	
	@PostMapping(path="/simulationbybank/{name}")
	@ResponseBody
	public CreditDto simulationbybank( @RequestBody CreditDto credit,@PathVariable("name") String name) {
		
		return calculationservice.CalculeCreditByBank(credit, name);
		
	}
	
	//estimation of house 
	
	@PostMapping(path="/estimate")
	@ResponseBody
	public float estimate(@RequestBody HouseDto  house){
	return	calculationservice.estimate(house);
	}
}

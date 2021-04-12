package tn.esprit.spring.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.dto.CreditDto;
import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.service.SimulationService;
import tn.esprit.spring.service.EmailService;
import tn.esprit.spring.service.EstimationService;


@RestController
@RequestMapping("/calculation")
public class CalculationController {
	@Autowired
    SimulationService simulationService ;
	@Autowired
	EmailService emailsevice;
	@Autowired
	EstimationService estimationService;
	
	//simulation of credit  by Interest Rate
	
	@PostMapping(path="/simulationByIr")
	@ResponseBody
	public CreditDto calcule( @RequestBody CreditDto creditDto) {
		
		return simulationService.CalculeCreditByIr(creditDto);
		
	}
	
	//simulation of credit in all bank
	
	@PostMapping(path="/simulationInAllBank")
	@ResponseBody
	public  Map<String, Double> calculeByIr( @RequestBody CreditDto credit) {
		return simulationService.CalculeCreditInAllBank(credit) ;
		
	}
	
	
	
	//simulation of credit by bank
	
	@PostMapping(path="/simulationbybank/{name}")
	@ResponseBody
	public Map<String,Double> simulationbybank( @RequestBody CreditDto credit,@PathVariable("name") String name) {
		
		return simulationService.CalculeCreditByBank(credit, name);
		
	}
	
	//estimation of house 
	
	@PostMapping(path="/estimation")
	@ResponseBody
	public Map<String,Float> estimation(@RequestBody HouseDto  house){
	return	estimationService.estimation(house);
	}
	
	//estimation of house with send to email
	
	@PostMapping(path="/estimationWithMail/{email}")
	@ResponseBody
	public Map<String,Float> estimationWithMail(@RequestBody HouseDto  house,@PathVariable("email") String email){
		
	emailsevice.sendSimpleMessage(email, "simulation", estimationService.estimation(house).toString());
	return	estimationService.estimation(house);
	}
	
}

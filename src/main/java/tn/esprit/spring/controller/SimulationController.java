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
import tn.esprit.spring.service.SimulationService;


@RestController
@RequestMapping("/simulation")
public class SimulationController {
	@Autowired
    SimulationService simulationService ;
	
	
	//simulation of credit  by Interest Rate
	
	@PostMapping(path="/simulationByIr")
	@ResponseBody
	public CreditDto calcule( @RequestBody CreditDto creditDto) {
		
		return simulationService.CalculeCreditByIr(creditDto);
		
	}
	
	//simulation of credit  by Interest Rate with save in database 
	@PostMapping(path="/simulationByIrSave")
	@ResponseBody
	public CreditDto calculeWithSave( @RequestBody CreditDto creditDto) {
		
		return simulationService.CalculeCreditByIrSave(creditDto);
		
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

	
}

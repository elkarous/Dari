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
import tn.esprit.spring.entities.House;
import tn.esprit.spring.service.CalculationService;
import tn.esprit.spring.service.EmailService;


@RestController
@RequestMapping("/")
public class CalculationControl {
	@Autowired
    CalculationService calculationservice ;
	@Autowired
	EmailService emailsevice;
	
	@PostMapping(path="/simulation")
	@ResponseBody
	public CreditDto calcule( @RequestBody CreditDto creditDto) {
		// emailsevice.sendSimpleMessage("elkarous.elkilani@gmail.com", "simulation", credit.toString());
		
		return calculationservice.CalculeCredit(creditDto);
		
	}
	
	@PostMapping(path="/calculeByIr")
	@ResponseBody
	public Map<String, Double> calculeByIr( @RequestBody CreditDto credit) {
		return calculationservice.CalculeCreditByIR(credit) ;
		
	}
	
	@PostMapping(path="/simulationbybank/{name}")
	@ResponseBody
	public CreditDto simulationbybank( @RequestBody CreditDto credit,@PathVariable("name") String name) {
		
		return calculationservice.CalculeCreditByBank(credit, name);
		
	}
	
	
	@PostMapping(path="/estimate")
	@ResponseBody
	public float estimate(@RequestBody House  house){
	return	calculationservice.estimate(house);
	}
}

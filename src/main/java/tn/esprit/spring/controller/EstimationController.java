package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.dto.UnitPriceDto;
import tn.esprit.spring.entities.UnitPrice;
import tn.esprit.spring.service.EmailService;
import tn.esprit.spring.service.EstimationService;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/estimation")
public class EstimationController {

	@Autowired
	EmailService emailsevice;
	@Autowired
	EstimationService estimationService;
	
	@GetMapping("/getUnitPriceByMunicipale/{municipale}")
	@ResponseBody 
	public UnitPrice getUnitPriceByMunicipale(@PathVariable("municipale") String municipale ){
		return estimationService.getUnitpriceByMunicipal(municipale);
	}
	
	// add unit price 
	
	@PostMapping("/addunitprice")
	@ResponseBody
	public UnitPriceDto addunitprice(@RequestBody UnitPriceDto  unitPriceDto){
	return	estimationService.addUnitPrice(unitPriceDto);
		
		
	}
	
	//delete unit price  by id
	
	@DeleteMapping("/deleteunitprice/{id}")
	@ResponseBody 
	public void deleteUnitPriceByID(@PathVariable("id") Long id ){
		estimationService.deleteUnitPrice(id);
	}
	
	//get all banks
	
	@GetMapping("/getAllUnitprice")
    @ResponseBody
	public List<UnitPriceDto> getAllEmployes() {
		
		return estimationService.getAll();
	}
	
  //update  unit price 
	
	@PutMapping("/updateunitprice")
	@ResponseBody 
	public UnitPriceDto updateUnPrice(@RequestBody UnitPriceDto unitPriceDto){
		return estimationService.updateUnitPrice(unitPriceDto);
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

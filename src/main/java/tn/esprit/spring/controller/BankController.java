package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankService bankService;
	
	
	@GetMapping("/getAllBanks")
    @ResponseBody
	public List<BankDto> getAllEmployes() {
		
		return bankService.getAllBanks();
	}
	
	
	@PostMapping("/addBank")
	@ResponseBody
	public BankDto addBank(@RequestBody BankDto  bank){
	return	bankService.addBank(bank);
		
		
	}
	
	
	@DeleteMapping("/deleteBank/{bankId}")
	@ResponseBody 
	public void deleteBankByID(@PathVariable("bankId") Long bankId ){
		bankService.deleteBankByID(bankId);
	}
	

	@PutMapping("/updateBank")
	@ResponseBody 
	public BankDto updateBank(@RequestBody BankDto bank){
		return bankService.updateBank(bank);
	}
	
	
	@GetMapping("/getAllBankByNames")
	@ResponseBody
	public List<String> getAllBankByNames(){
		return bankService.getAllBankByNames();
	}
	@PostMapping(path="/getALLBankByIr")
	@ResponseBody
	public List<BankDto> getALLBankByIr( @RequestBody double interestRate) {
		return bankService.getALLBankByIr(interestRate);
	}
	
	@PostMapping(path="/getBestOffres")
	@ResponseBody
	public List<BankOffersDto> getAllOffrersByMaxCredit( @RequestBody Credit credit) {
		return bankService.getAllOffrersByMaxCredit(credit.getAmount(),credit.getPeriod());
	}
	
	@PostMapping(path="/getBankByName")
	@ResponseBody
	public BankDto getBankByName( @RequestBody String name) {
		return bankService.getBankByName(name);
	}
	
	
	
	
	@PostMapping(path="/getBankOffreByname")
	@ResponseBody 
	public List<BankOffersDto> getBankOffreByBankName(@RequestBody String bank){
		return bankService.getAllOffrersByBank(bank);
	}
	
}

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




import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankControl {

	@Autowired
	BankService bankService;
	
	
	@GetMapping("/getAllBanks")
    @ResponseBody
	public List<Bank> getAllEmployes() {
		
		return bankService.getAllBanks();
	}
	
	
	@PostMapping("/addBank")
	@ResponseBody
	public Bank addBank(@RequestBody Bank  bank){
	return	bankService.addBank(bank);
		
		
	}
	
	
	@DeleteMapping("/deleteBank/{bankId}")
	@ResponseBody 
	public void deleteBankByID(@PathVariable("bankId") Long bankId ){
		bankService.deleteBankByID(bankId);
	}
	

	@PutMapping("/updateBank")
	@ResponseBody 
	public Bank updateBank(@RequestBody Bank bank){
		return bankService.updateBank(bank);
	}
	
	
	@GetMapping("/getAllBankByNames")
	@ResponseBody
	public List<String> getAllBankByNames(){
		return bankService.getAllBankByNames();
	}
	@PostMapping(path="/getALLBankByIr")
	@ResponseBody
	public List<Bank> getALLBankByIr( @RequestBody double interestRate) {
		return bankService.getALLBankByIr(interestRate);
	}
	
	@PostMapping(path="/getAllOffrersByMaxCredit")
	@ResponseBody
	public List<BankOffers> getAllOffrersByMaxCredit( @RequestBody double amount) {
		return bankService.getAllOffrersByMaxCredit(amount);
	}
	
	@PostMapping(path="/getBankByName")
	@ResponseBody
	public Bank getBankByName( @RequestBody String name) {
		return bankService.getBankByName(name);
	}
}

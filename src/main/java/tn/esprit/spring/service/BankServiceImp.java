package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;

import tn.esprit.spring.repository.BankOffersRepository;
import tn.esprit.spring.repository.BankRepository;

@Service
public class BankServiceImp implements BankService {

	@Autowired
	BankRepository bankRepository;
	@Autowired 
	BankOffersRepository bankOffresRepository;
	@Override
	public List<Bank> getAllBanks() {
		return (List<Bank>) bankRepository.findAll();
		
	}

	@Override
	public Bank addBank(Bank bank) {
		return	bankRepository.save(bank);
		
	}

	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}

	@Override
	public Bank updateBank(Bank bank) {
		
		return bankRepository.save(bank);
	}

	@Override
	public List<String> getAllBankByNames() {
		
		return bankRepository.getAllBankByNames();
	}
	
	@Override
	public List<BankOffers> getAllOffrersByMaxCredit( double amount ){
		return bankOffresRepository.getAllOffreByMax(amount);
	}
	@Override
	public List<Bank> getALLBankByIr(double interestRate){
		return bankRepository.getAllBankByTaux(interestRate);
		
	}
	@Override
	public Bank getBankByName(String name) {
		
		return bankRepository.getBankByName(name);
	}
}

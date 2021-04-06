package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;



public interface BankService {

	List<Bank> getAllBanks();
	public Bank addBank(Bank bank);
	public void deleteBankByID(Long bankID );
	public Bank updateBank(Bank bank);
	List<String> getAllBankByNames();
	List<Bank> getALLBankByIr(double interestRate);
	List<BankOffers> getAllOffrersByMaxCredit(double amount);
	Bank getBankByName(String name);
}

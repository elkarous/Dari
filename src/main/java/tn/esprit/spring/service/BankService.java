package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.entities.BankOffers;




public interface BankService {

	List<BankDto> getAllBanks();
	public BankDto addBank(BankDto bank);
	public void deleteBankByID(Long bankID );
	List<String> getAllBankByNames();
	List<BankDto> getALLBankByIr(double interestRate);
	BankDto getBankByName(String name);
	BankDto updateBank(BankDto bankdto);
	List<BankOffersDto> getAllOffrersByMaxInBank(String name,double amount);
	List<BankOffers> getAllOffrersByBank(Long name);
	List<BankOffersDto> getAllOffrersByMaxCredit(double amount, int period);
}

package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;





public interface BankService {

	public List<BankDto> getAllBanks();
	public BankDto addBank(BankDto bank);
	public void deleteBankByID(Long bankID );
	public List<String> getAllBankByNames();
	public List<BankDto> getALLBankByIr(double interestRate);
	public BankDto getBankByName(String name);
	public BankDto updateBank(BankDto bankdto);
	public List<BankOffersDto> getAllOffrersByBank(String name);
	public List<BankOffersDto> getAllOffrersByMaxCredit(double amount, int period);
	public BankOffersDto addBankOffre(BankOffersDto bankoffredto,Long id);
	public void deleteBankoffreByID(Long id,Long idBank);
	public BankOffersDto updateBankOffre(BankOffersDto bankoffredto);
}

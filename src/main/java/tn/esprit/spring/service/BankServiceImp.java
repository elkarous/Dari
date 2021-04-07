package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;
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
	public List<BankDto> getAllBanks() {
		
		List<BankDto> bankDtos = new ArrayList<>();
		List<Bank> banks= (List<Bank>) bankRepository.findAll();
		for(Bank bank :banks) {
			
		 ModelMapper modelMapper = new ModelMapper();
		BankDto bankdto = modelMapper.map(bank, BankDto.class);
		bankDtos.add(bankdto);
		}
		return bankDtos;	
	}

	@Override
	public BankDto addBank(BankDto bankdto) {
		Bank bank= bankRepository.getBankByName(bankdto.getName());
		if(bank!=null)
		{ 
			throw  new RuntimeException("there is a Bank with this name , go to update ");
		}
		 ModelMapper modelMapper = new ModelMapper();
		bank = modelMapper.map(bankdto, Bank.class);
		bankRepository.save(bank);
		
		return	bankdto;
		
	}

	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}

	@Override
	public BankDto updateBank(BankDto bankdto) {
		Bank bank= bankRepository.findById(bankdto.getId()).get();
		if(bank!=null)
		{ 
			ModelMapper modelMapper = new ModelMapper();
			 bank = modelMapper.map(bankdto, Bank.class);
			bankRepository.save(bank);
		}
		 
		return  bankdto;
	}

	@Override
	public List<String> getAllBankByNames() {
		
		return bankRepository.getAllBankByNames();
	}
	
	@Override
	public List<BankOffersDto> getAllOffrersByMaxCredit( double amount,int period ){
		List<BankOffersDto> bankoffresdtos = new ArrayList<>();
		List<BankOffers> bankoffress= (List<BankOffers>) bankOffresRepository.getAllOffreByMax(amount,period);
		for(BankOffers bankoffre :bankoffress) {
		 ModelMapper modelMapper = new ModelMapper();
		 BankOffersDto bankoffredto = modelMapper.map(bankoffre, BankOffersDto.class);
		 bankoffresdtos.add(bankoffredto);
		}
		return bankoffresdtos;
	}
	
	@Override
	public List<BankDto> getALLBankByIr(double interestRate){
		List<BankDto> bankDtos = new ArrayList<>();
		List<Bank> banks= (List<Bank>) bankRepository.getAllBankByTaux(interestRate);
		for(Bank bank :banks) {
			
		 ModelMapper modelMapper = new ModelMapper();
		BankDto bankdto = modelMapper.map(bank, BankDto.class);
		bankDtos.add(bankdto);
		}
		return bankDtos;	
		
	}
	@Override
	public BankDto getBankByName(String name) {
		Bank bank=bankRepository.getBankByName(name);
		
		 ModelMapper modelMapper = new ModelMapper();
		BankDto bankdto = modelMapper.map(bank, BankDto.class);
		
		return bankdto;
	}
	
	@Override
	public List<BankOffersDto> getAllOffrersByMaxInBank( String name,double amount ){
		List<BankOffersDto> bankoffresdtos = new ArrayList<>();
		 Bank bank=bankRepository.getBankByName(name);
		 for(BankOffers bankoffre:bank.getBankOffer()) {
			 
				 
			 ModelMapper modelMapper = new ModelMapper();
			 BankOffersDto bankoffredto = modelMapper.map(bankoffre, BankOffersDto.class);
			 
			 bankoffresdtos.add(bankoffredto);
			 
			
			 }
			return bankoffresdtos;
	}
	@Override
public	List<BankOffers> getAllOffrersByBank( Long name){
		return bankOffresRepository.getBankOffre(name);
	}
	
}

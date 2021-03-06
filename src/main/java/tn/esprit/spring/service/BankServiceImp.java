package tn.esprit.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.dto.BankDto;
import tn.esprit.spring.dto.BankOffersDto;
import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.BankOffers;
import tn.esprit.spring.repository.BankOffersRepository;
import tn.esprit.spring.repository.BankRepository;
import tn.esprit.spring.repository.FileDBRepository;

@Service
public class BankServiceImp implements BankService {

	@Autowired
	BankRepository bankRepository;
	@Autowired 
	BankOffersRepository bankOffresRepository;
	  @Autowired
  private FileStorageService fileDBService;
	
	// get All Banks
	
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

	// add bank 
	
	@Override
	public BankDto addBank(BankDto bankdto)  {
		Bank bank= bankRepository.getBankByName(bankdto.getName());
		if(bank!=null)
		{ 
			throw  new RuntimeException("there is a Bank with this name check the name or  go to update ");
		}
		 ModelMapper modelMapper = new ModelMapper();
		bank = modelMapper.map(bankdto, Bank.class);
		
		bankRepository.save(bank);
		return	bankdto;
		
	}

	//delete bank by id
	
	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}
	 //update bank 
	
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
	
	// get all bank by name 

	@Override
	public List<String> getAllBankByNames() {
		
		return bankRepository.getAllBankByNames();
	}
	
	//get all offer by amount and period 
	
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
	
	// get all bank by interest rate 
	
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
	// get bank class by name 
	
	@Override
	public BankDto getBankByName(String name) {
		Bank bank=bankRepository.getBankByName(name);
		 ModelMapper modelMapper = new ModelMapper();
		BankDto  bankdto = modelMapper.map(bank, BankDto.class);
		
		return bankdto;
	}
	
	//get offers of bank by bank name 
	
	@Override
public	List<BankOffersDto> getAllOffrersByBank( String name){
		List<BankOffersDto> bankoffresdtos = new ArrayList<BankOffersDto>();
		 Bank bank=bankRepository.getBankByName(name);
		 for(BankOffers bankoffre:bank.getBankOffer()) {
			 
			 
			 ModelMapper modelMapper = new ModelMapper();
			 BankOffersDto bankoffredto = modelMapper.map(bankoffre, BankOffersDto.class);
			 
			 bankoffresdtos.add(bankoffredto);
			 
			
			 }
			return bankoffresdtos;
	}
	// add bankOffre 
	
		@Override
		public BankOffersDto addBankOffre(BankOffersDto bankoffredto,Long id ) {
			Bank bank=bankRepository.findById(id).get();
			 ModelMapper modelMapper = new ModelMapper();
			BankOffers bankOffre = modelMapper.map(bankoffredto, BankOffers.class);
			bank.getBankOffer().add(bankOffre);
			bankRepository.save(bank);
			
			return	bankoffredto;
			
		}

		//delete bank by id
		
		@Override
		public void deleteBankoffreByID(Long id,Long idBank) {
			BankOffers offre=bankOffresRepository.findById(id).get();
			Bank bank=bankRepository.findById(idBank).get();
			bank.getBankOffer().remove(offre);
			bankRepository.save(bank);
			
		}
		 //update bank offer
		
		@Override
		public BankOffersDto updateBankOffre (BankOffersDto bankoffredto) {
			
				ModelMapper modelMapper = new ModelMapper();
				BankOffers bankOffre = modelMapper.map(bankoffredto, BankOffers.class);
				bankOffresRepository.save(bankOffre);
			
			 
			return  bankoffredto;
		}
	
}

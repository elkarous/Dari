package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

    @Query("SELECT name FROM Bank")
    public List<String> getAllBankByNames();
    
    @Query("SELECT b FROM Bank b where b.name =:name ")
    public Bank getBankByName(@Param("name") String name);
    
    @Query("SELECT b FROM Bank b where b.interestRate<=:interestRate")
    public List<Bank> getAllBankByTaux(@Param("interestRate") double interestRate);
    
  
    
    
}

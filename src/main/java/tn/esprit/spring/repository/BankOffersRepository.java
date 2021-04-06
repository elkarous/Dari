package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.BankOffers;

public interface BankOffersRepository extends CrudRepository<BankOffers, Long> {
	 @Query("SELECT b FROM BankOffers b where b.maxCredit>=:maxCredit OR  b.maxCredit=0")
	    public List<BankOffers> getAllOffreByMax( @Param("maxCredit")double maxCredit);
}

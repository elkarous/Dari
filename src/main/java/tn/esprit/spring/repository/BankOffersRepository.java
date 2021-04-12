package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.BankOffers;
@Repository
public interface BankOffersRepository extends CrudRepository<BankOffers, Long> {
	 @Query("SELECT b FROM BankOffers b where (b.maxCredit>=:maxCredit OR  b.maxCredit=0)and b.period<=:period")
	    public List<BankOffers> getAllOffreByMax( @Param("maxCredit")double maxCredit,@Param("period")int period);
	 

	 
}

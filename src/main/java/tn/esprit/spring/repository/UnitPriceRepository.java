package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entities.UnitPrice;

public interface UnitPriceRepository  extends CrudRepository<UnitPrice, Long>{
	
	  @Query("SELECT minunitprice FROM UnitPrice where postalCode=postalCode")
	    public float getUnitPrice(int postalCode);
}

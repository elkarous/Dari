package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.UnitPrice;

public interface UnitPriceRepository  extends CrudRepository<UnitPrice, Long>{
	
	  @Query("SELECT minunitprice FROM UnitPrice where municipal=:municipal")
	    public float getUnitPrice(@Param("municipal") String municipal);
}

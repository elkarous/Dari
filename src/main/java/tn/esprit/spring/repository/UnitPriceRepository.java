package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.UnitPrice;
@Repository
public interface UnitPriceRepository  extends CrudRepository<UnitPrice, Long>{
	
	  @Query("SELECT minunitprice FROM UnitPrice where municipal=:municipal")
	    public Float getMinUnitPrice(@Param("municipal") String municipal);
	  

	  @Query("SELECT maxunitprice FROM UnitPrice where municipal=:municipal")
	    public Float getMaxUnitPrice(@Param("municipal") String municipal);
	  
	  @Query("SELECT u FROM UnitPrice u where u.municipal=:municipal")
	  public UnitPrice findByMunicipal (@Param("municipal") String municipal);
}

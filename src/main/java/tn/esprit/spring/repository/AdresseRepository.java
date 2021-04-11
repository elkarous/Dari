package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Adress;

@Repository
public interface AdresseRepository  extends CrudRepository<Adress, Long>{

}

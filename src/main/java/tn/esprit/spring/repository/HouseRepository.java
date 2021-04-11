package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.House;
@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

}

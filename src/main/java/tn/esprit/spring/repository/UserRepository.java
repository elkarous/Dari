package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(" select u from User u  where u.username =:username")
    Optional<User> findUserWithName(@Param("username") String username);
}
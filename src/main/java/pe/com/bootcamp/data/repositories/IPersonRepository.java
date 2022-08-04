package pe.com.bootcamp.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.entities.PersonPK;

@Repository
public interface IPersonRepository extends JpaRepository<Person, PersonPK>  {

	
}

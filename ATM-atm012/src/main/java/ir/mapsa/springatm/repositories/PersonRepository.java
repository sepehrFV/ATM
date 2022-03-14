package ir.mapsa.springatm.repositories;

import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.generics.GenericRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GenericRepository<Person, Long> {


}

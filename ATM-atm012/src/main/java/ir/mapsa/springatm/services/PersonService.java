package ir.mapsa.springatm.services;

import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.generics.GenericRepository;
import ir.mapsa.springatm.generics.GenericServiceImp;
import ir.mapsa.springatm.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PersonService extends GenericServiceImp<Person, Long> implements IPersonService {

    private PersonRepository repository;

    @Override
    protected GenericRepository<Person, Long> getRepository() {
        return repository;
    }


}

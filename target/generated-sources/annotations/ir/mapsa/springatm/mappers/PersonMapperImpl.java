package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.PersonDTO;
import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.entities.Person.PersonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-09T00:48:57+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toEntity(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        return person.build();
    }

    @Override
    public PersonDTO toDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        return personDTO;
    }

    @Override
    public List<Person> toEntities(List<PersonDTO> dtoes) {
        if ( dtoes == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( dtoes.size() );
        for ( PersonDTO personDTO : dtoes ) {
            list.add( toEntity( personDTO ) );
        }

        return list;
    }

    @Override
    public List<PersonDTO> toDtoes(List<Person> entites) {
        if ( entites == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( entites.size() );
        for ( Person person : entites ) {
            list.add( toDto( person ) );
        }

        return list;
    }

    @Override
    public void update(Person entity, PersonDTO dto) {
        if ( dto == null ) {
            return;
        }
    }
}

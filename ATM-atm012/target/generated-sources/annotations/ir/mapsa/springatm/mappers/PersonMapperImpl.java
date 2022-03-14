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
    date = "2022-03-14T13:11:43+0330",
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

        person.name( dto.getName() );
        person.family( dto.getFamily() );
        person.national_ID( dto.getNational_ID() );
        person.age( dto.getAge() );

        return person.build();
    }

    @Override
    public PersonDTO toDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setName( entity.getName() );
        personDTO.setFamily( entity.getFamily() );
        personDTO.setNational_ID( entity.getNational_ID() );
        personDTO.setAge( entity.getAge() );

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

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getFamily() != null ) {
            entity.setFamily( dto.getFamily() );
        }
        if ( dto.getNational_ID() != null ) {
            entity.setNational_ID( dto.getNational_ID() );
        }
        if ( dto.getAge() != null ) {
            entity.setAge( dto.getAge() );
        }
    }
}

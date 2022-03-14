package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.PersonDTO;
import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericMapper<Person, PersonDTO> {

}

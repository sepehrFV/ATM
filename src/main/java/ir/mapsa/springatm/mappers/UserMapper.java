package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.UserDTO;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {

}

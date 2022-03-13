package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.UserDTO;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.entities.User.UserBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-13T14:12:46+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        return user.build();
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        return userDTO;
    }

    @Override
    public List<User> toEntities(List<UserDTO> dtoes) {
        if ( dtoes == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoes.size() );
        for ( UserDTO userDTO : dtoes ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDtoes(List<User> entites) {
        if ( entites == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entites.size() );
        for ( User user : entites ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public void update(User entity, UserDTO dto) {
        if ( dto == null ) {
            return;
        }
    }
}

package ir.mapsa.springatm.services;

import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.generics.GenericRepository;
import ir.mapsa.springatm.generics.GenericServiceImp;
import ir.mapsa.springatm.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService extends GenericServiceImp<User, Long> implements IUserService {

    private UserRepository repository;

    @Override
    protected GenericRepository<User, Long> getRepository() {
        return repository;
    }


}

package ir.mapsa.springatm.repositories;

import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Long> {

    User findByUsername(String username);

}

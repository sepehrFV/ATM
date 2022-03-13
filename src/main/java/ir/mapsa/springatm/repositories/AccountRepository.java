package ir.mapsa.springatm.repositories;

import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.generics.GenericRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends GenericRepository<Account, Long> {

    List<Account> findAllByUser_Id(Long userId);


}

package ir.mapsa.springatm.repositories;

import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.generics.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends GenericRepository<Transaction, Long> {

    List<Transaction> findAllByAccount_AccountNumber(Long accId);

    Page<Transaction> findAllByAccount_AccountNumber(Long accId, Pageable pageable);

    Transaction findByDate(Date date);

}

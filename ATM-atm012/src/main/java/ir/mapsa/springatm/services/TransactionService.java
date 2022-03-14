package ir.mapsa.springatm.services;


import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.enums.TransactionType;
import ir.mapsa.springatm.generics.GenericRepository;
import ir.mapsa.springatm.generics.GenericServiceImp;
import ir.mapsa.springatm.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService extends GenericServiceImp<Transaction, Long> implements ITransactionService {


    private TransactionRepository repository;

    @Override
    protected GenericRepository<Transaction, Long> getRepository() {
        return repository;
    }


    @Override
    public List<Transaction> findAllByAccId(Long accId) {
        return repository.findAllByAccount_AccountNumber(accId);
    }

    @Override
    public Transaction findTransactionByDateAndTime(Date date) {
        return repository.findByDate(date);
    }



}

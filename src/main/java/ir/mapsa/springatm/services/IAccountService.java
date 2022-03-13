package ir.mapsa.springatm.services;

import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.generics.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IAccountService extends IGenericService<Account, Long> {


    Account createAccount(Long personId, Account account);

    void deposit(Long accId, Double amount);

    void withdraw(Long accId, Double amount);

    void transfer(Long accId,Long receiverAccId,Double amount);

    Double showBalance(Long accId);

    String ownerFullName(Long accId);

    boolean validatePassword(Long accId, String password);

    User getUserInfoByAccountNumber(Long accId);

    List<Account> getAccountsByPersonId(Long personId);

    List<Transaction> findAllTransactionByAccNumber(Long accId);


}

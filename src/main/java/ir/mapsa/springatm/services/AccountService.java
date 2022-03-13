package ir.mapsa.springatm.services;

import ir.mapsa.springatm.exeptions.BusinessException;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.enums.TransactionType;
import ir.mapsa.springatm.generics.GenericRepository;
import ir.mapsa.springatm.generics.GenericServiceImp;
import ir.mapsa.springatm.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService extends GenericServiceImp<Account, Long> implements IAccountService {


    private IUserService personService;
    private ITransactionService transactionService;
    private AccountRepository repository;


    @Override
    protected GenericRepository<Account, Long> getRepository() {
        return repository;
    }


    @Override
    public Account createAccount(Long userId, Account account) {

        User user = personService.findById(userId).get();
        account.setUser(user);

        return repository.save(account);
    }


    @Override
    public void deposit(Long accId, Double amount) {
        Account account = findById(accId).get();
        if (account.getBalance() < amount) {
            throw new BusinessException("requested amount more than balance");
        } else {
            Double updatedBalance = (account.getBalance()) + amount;
            account.setBalance(updatedBalance);
            save(account);
            Transaction transaction = Transaction.builder()
                    .account(account)
                    .type(TransactionType.DEPOSIT)
                    .amount(amount)
                    .date(new Date())
                    .build();
            transactionService.save(transaction);
        }

    }

    @Override
    public void withdraw(Long accId, Double amount) {
        Account account = findById(accId).get();
        if (account.getBalance() < amount) {
            throw new BusinessException("requested amount more than balance");
        } else {
            Double updatedBalance = (account.getBalance()) - amount;
            account.setBalance(updatedBalance);
            save(account);
            Transaction transaction = Transaction.builder()
                    .account(account)
                    .type(TransactionType.WITHDRAW)
                    .amount(amount)
                    .date(new Date())
                    .build();
            transactionService.save(transaction);
        }
    }

    @Override
    public void transfer(Long accId, Long receiverAccId, Double amount) {
        withdraw(accId,amount);
        deposit(receiverAccId,amount);
    }

    @Override
    public Double showBalance(Long accId) {
        return findById(accId).get().getBalance();
    }

    @Override
    public String ownerFullName(Long accId) {
        Account account = findById(accId).get();
        String fullName = account.getUser().getName() + " " + account.getUser().getFamily();
        return fullName;
    }

    @Override
    public boolean validatePassword(Long accId, String password) {

        if (findById(accId).get().getPassword().equals(password)) {
            return true;
        }else return false;
    }

    @Override
    public User getUserInfoByAccountNumber(Long accNum) {
        Optional<Account> account = repository.findById(accNum);
        return account.get().getUser();
    }

    @Override
    public List<Account> getAccountsByPersonId(Long userId) {
        return repository.findAllByUser_Id(userId);
    }

    @Override
    public List<Transaction> findAllTransactionByAccNumber(Long accId) {
        if (repository.existsById(accId)) {
            return transactionService.findAllByAccId(accId);
        } else throw new NotFoundException("id not exists");

    }



}

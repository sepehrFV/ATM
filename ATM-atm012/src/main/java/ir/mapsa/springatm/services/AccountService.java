package ir.mapsa.springatm.services;

import ir.mapsa.springatm.exeptions.BusinessException;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.enums.TransactionType;
import ir.mapsa.springatm.generics.GenericRepository;
import ir.mapsa.springatm.generics.GenericServiceImp;
import ir.mapsa.springatm.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService extends GenericServiceImp<Account, Long> implements IAccountService {


    private IPersonService personService;
    private ITransactionService transactionService;
    private AccountRepository repository;


    @Override
    protected GenericRepository<Account, Long> getRepository() {
        return repository;
    }


    @Override
    public Account createAccount(Long personId, Account account) {

        Person person = personService.findById(personId).get();
        account.setPerson(person);

        return repository.save(account);
    }


    @Override
    public void deposit(Long accId, Double amount) {

            Account account = findById(accId).get();
            Double updatedBalance = (account.getBalance()) + amount;
            account.setBalance(updatedBalance);
            save(account);
            createTransaction(account,amount,TransactionType.DEPOSIT);


    }

    @Override
    public void createTransaction(Account a, Double amount, TransactionType type) {
        Transaction tr = Transaction.builder()
                .account(a)
                .date(new Date())
                .type(type)
                .amount(amount)
                .build();
        transactionService.save(tr);
    }

    @Override
    public void withdraw(Long accId, Double amount) {
        Account account = findById(accId).get();
        if (account.getBalance() < amount) {
            throw new BusinessException("requested amount more than your account balance");
        } else {
            Double updatedBalance = (account.getBalance()) - amount;
            account.setBalance(updatedBalance);
            save(account);
            createTransaction(account,amount,TransactionType.WITHRAW);
        }
    }

    @Override
    public Double showBalance(Long accId) {
        return findById(accId).get().getBalance();
    }

    @Override
    public String ownerFullName(Long accId) {
        Account account = findById(accId).get();
        String fullName = account.getPerson().getName() + " " + account.getPerson().getFamily();
        return fullName;
    }

    @Override
    public boolean validatePassword(Long accId, String password) {

        if (findById(accId).get().getPassword().equals(password)) {
            return true;
        }else return false;
    }

    @Override
    public Person getPersonInfoByAccountNumber(Long accNum) {
        Optional<Account> account = repository.findById(accNum);
        return account.get().getPerson();
    }

    @Override
    public List<Account> getAccountsByPersonId(Long personId) {
        return repository.findAllByPerson_Id(personId);
    }

    @Override
    public List<Transaction> findAllTransactionByAccNumber(Long accId) {
        if (repository.existsById(accId)) {
            return transactionService.findAllByAccId(accId);
        } else throw new NotFoundException("id not exists");

    }


}

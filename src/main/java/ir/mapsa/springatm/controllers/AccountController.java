package ir.mapsa.springatm.controllers;

import ir.mapsa.springatm.dto.AccountDTO;
import ir.mapsa.springatm.dto.PersonDTO;
import ir.mapsa.springatm.dto.TransactionDTO;
import ir.mapsa.springatm.mappers.AccountMapper;
import ir.mapsa.springatm.mappers.PersonMapper;
import ir.mapsa.springatm.mappers.TransactionMapper;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
@AllArgsConstructor
public class AccountController {

    private final IAccountService service;
    private final AccountMapper mapper;
    private final TransactionMapper transactionMapper;
    private final PersonMapper personMapper;


    @PostMapping(value = "/create/{personId}")
    public ResponseEntity<Void> createAccount(@PathVariable(name = "personId") Long personId, @RequestBody @Valid Account account){
        service.createAccount(personId,account);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/findByAccountNumber/{accountNumber}")
    public ResponseEntity<AccountDTO> findByAccountNumber(@PathVariable(name = "accountNumber") Long accId){

        return new ResponseEntity<>(mapper.toDto(service.findById(accId).get()),HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<AccountDTO>> findAll(){
        return ResponseEntity.ok(mapper.toDtoes(service.findAll()));
    }

    @DeleteMapping(value = "/deleteById/{accId}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "accId") Long accId){
        service.deleteById(accId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping (value = "/deposit/{amount}/{accountNumber}")
    public ResponseEntity<Void> deposit(@PathVariable(value = "amount") Double amount,@PathVariable(value = "accountNumber") Long accId){
        service.deposit(accId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping (value = "/withdraw/{amount}/{accountNumber}")
    public ResponseEntity<Void> withdraw(@PathVariable(value = "amount") Double amount,@PathVariable(value = "accountNumber") Long accId){
        service.withdraw(accId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findAllTransactions/{acountNumber}")
    public ResponseEntity<List<TransactionDTO>> findAllTransactions(@PathVariable(value = "accountNumber") Long accId){
        List<Transaction> transactions = service.findAllTransactionByAccNumber(accId);
        return new ResponseEntity<>(transactionMapper.toDtoes(transactions),HttpStatus.OK);
    }

    @GetMapping(value = "/showBalance/{accountNumber}")
    public ResponseEntity<Double> showBalance(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(service.showBalance(accId),HttpStatus.OK);
    }

    @GetMapping(value = "/showPersonFullName/{accountNumber}")
    public ResponseEntity<String> showOwnerFullName(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(service.ownerFullName(accId),HttpStatus.OK);
    }

    @GetMapping(value = "/validate/{accountNumber}/{password}")
    public ResponseEntity<Boolean> validate(@PathVariable(value = "accountNumber") Long accId,@PathVariable(value = "password") String pass){
        return new ResponseEntity<>(service.validatePassword(accId, pass),HttpStatus.OK);
    }

    @GetMapping(value = "/findPersonByAccountNumber/{accountNumber}")
    public ResponseEntity<PersonDTO> findPersonByAccNum(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(personMapper.toDto(service.getPersonInfoByAccountNumber(accId)),HttpStatus.OK);
    }
    @GetMapping(value = "/findPersonByAccountNumber/{personId}")
    public ResponseEntity<List<AccountDTO>> findAccountByPersonId(@PathVariable(value = "personId") Long personId){
        return new ResponseEntity<>(mapper.toDtoes(service.getAccountsByPersonId(personId)),HttpStatus.OK);
    }






}

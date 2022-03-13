package ir.mapsa.springatm.controllers;

import ir.mapsa.springatm.dto.AccountDTO;
import ir.mapsa.springatm.dto.UserDTO;
import ir.mapsa.springatm.dto.TransactionDTO;
import ir.mapsa.springatm.mappers.AccountMapper;
import ir.mapsa.springatm.mappers.UserMapper;
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
    private final UserMapper userMapper;

    @GetMapping(value = "/page")
    public String page(){
        return "This is account page";
    }

    @PostMapping(value = "/{userId}")
    public ResponseEntity<Void> createAccount(@PathVariable(name = "userId") Long userId, @RequestBody @Valid Account account){
        service.createAccount(userId,account);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/byAccountNumber/{accountNumber}")
    public ResponseEntity<AccountDTO> findByAccountNumber(@PathVariable(name = "accountNumber") Long accId){

        return new ResponseEntity<>(mapper.toDto(service.findById(accId).get()),HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AccountDTO>> findAll(){
        return ResponseEntity.ok(mapper.toDtoes(service.findAll()));
    }

    @DeleteMapping(value = "/byId/{accId}")
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

    @GetMapping(value = "/transfer/{senderAccId}/{receiverAccId}/{amount}")
    public ResponseEntity<Void> transfer(@PathVariable(value = "senderAccId") Long accId,
                                         @PathVariable(value = "receiverAccId") Long receiverAccId,
                                         @PathVariable(value = "amount") Double amount){
        service.transfer(accId,receiverAccId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/allTransactions/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> findAllTransactions(@PathVariable(value = "accountNumber") Long accId){
        List<Transaction> transactions = service.findAllTransactionByAccNumber(accId);
        return new ResponseEntity<>(transactionMapper.toDtoes(transactions),HttpStatus.OK);
    }


    @GetMapping(value = "/balance/{accountNumber}")
    public ResponseEntity<Double> showBalance(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(service.showBalance(accId),HttpStatus.OK);
    }

    @GetMapping(value = "/personFullName/{accountNumber}")
    public ResponseEntity<String> showOwnerFullName(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(service.ownerFullName(accId),HttpStatus.OK);
    }

    @GetMapping(value = "/validate/{accountNumber}/{password}")
    public ResponseEntity<Boolean> validate(@PathVariable(value = "accountNumber") Long accId,@PathVariable(value = "password") String pass){
        return new ResponseEntity<>(service.validatePassword(accId, pass),HttpStatus.OK);
    }

    @GetMapping(value = "/userByAccountNumber/{accountNumber}")
    public ResponseEntity<UserDTO> findPersonByAccNum(@PathVariable(value = "accountNumber") Long accId){
        return new ResponseEntity<>(userMapper.toDto(service.getUserInfoByAccountNumber(accId)),HttpStatus.OK);
    }
    @GetMapping(value = "/findUserByAccountNumber/{userId}")
    public ResponseEntity<List<AccountDTO>> findAccountByPersonId(@PathVariable(value = "userId") Long userId){
        return new ResponseEntity<>(mapper.toDtoes(service.getAccountsByPersonId(userId)),HttpStatus.OK);
    }






}

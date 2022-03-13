package ir.mapsa.springatm.controllers;

import ir.mapsa.springatm.dto.TransactionDTO;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.services.IAccountService;
import ir.mapsa.springatm.services.ITransactionService;
import ir.mapsa.springatm.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {

    private final IAccountService accountService;
    private final IUserService userService;
    private final ITransactionService transactionService;

    @GetMapping(value = "/page")
    public String page(){
        return "This is admin page";
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions")
    public ResponseEntity<List<Transaction>> findAllTransactions() {
        return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/allTransactions/{accountNumber}/{page}/{size}")
    public ResponseEntity<Page<Transaction>> findTransactionPage(@PathVariable(value = "accountNumber") Long accId,
                                                                 @PathVariable(value = "page") Integer page,
                                                                 @PathVariable(value = "size") Integer size){

        return new ResponseEntity<>(transactionService.findTransactionPageByAccNumber(page,size,accId),HttpStatus.OK);
    }

    @DeleteMapping(value = "/account/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

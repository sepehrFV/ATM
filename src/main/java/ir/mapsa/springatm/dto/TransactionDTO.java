package ir.mapsa.springatm.dto;

import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.enums.TransactionType;

import java.util.Date;

public class TransactionDTO {

    private Long id;
    private Double amount;
    private Account account;
    private TransactionType type;
    private Date date;
}

package ir.mapsa.springatm.services;

import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.enums.TransactionType;
import ir.mapsa.springatm.generics.IGenericService;

import java.util.Date;
import java.util.List;

public interface ITransactionService extends IGenericService<Transaction,Long> {

    List<Transaction> findAllByAccId(Long accId);

    Transaction findTransactionByDateAndTime(Date date);



}

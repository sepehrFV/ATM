package ir.mapsa.springatm.services;

import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.enums.TransactionType;
import ir.mapsa.springatm.generics.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ITransactionService extends IGenericService<Transaction,Long> {

    List<Transaction> findAllByAccId(Long accId);

    Transaction findTransactionByDateAndTime(Date date);

    Page<Transaction> findTransactionPageByAccNumber(int page,int size,Long accId);

}

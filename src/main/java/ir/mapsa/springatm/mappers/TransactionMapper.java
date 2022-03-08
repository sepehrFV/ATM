package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.TransactionDTO;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<Transaction, TransactionDTO> {

}

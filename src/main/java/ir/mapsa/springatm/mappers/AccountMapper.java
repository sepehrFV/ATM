package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.AccountDTO;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends GenericMapper<Account,AccountDTO> {



}

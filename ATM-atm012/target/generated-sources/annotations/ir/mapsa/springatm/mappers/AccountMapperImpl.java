package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.AccountDTO;
import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.entities.Account.AccountBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-14T13:11:43+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.accountNumber( dto.getAccountNumber() );
        account.balance( dto.getBalance() );
        account.person( dto.getPerson() );

        return account.build();
    }

    @Override
    public AccountDTO toDto(Account entity) {
        if ( entity == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setAccountNumber( entity.getAccountNumber() );
        accountDTO.setBalance( entity.getBalance() );
        accountDTO.setPerson( entity.getPerson() );

        return accountDTO;
    }

    @Override
    public List<Account> toEntities(List<AccountDTO> dtoes) {
        if ( dtoes == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( dtoes.size() );
        for ( AccountDTO accountDTO : dtoes ) {
            list.add( toEntity( accountDTO ) );
        }

        return list;
    }

    @Override
    public List<AccountDTO> toDtoes(List<Account> entites) {
        if ( entites == null ) {
            return null;
        }

        List<AccountDTO> list = new ArrayList<AccountDTO>( entites.size() );
        for ( Account account : entites ) {
            list.add( toDto( account ) );
        }

        return list;
    }

    @Override
    public void update(Account entity, AccountDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAccountNumber() != null ) {
            entity.setAccountNumber( dto.getAccountNumber() );
        }
        if ( dto.getBalance() != null ) {
            entity.setBalance( dto.getBalance() );
        }
        if ( dto.getPerson() != null ) {
            entity.setPerson( dto.getPerson() );
        }
    }
}

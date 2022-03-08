package ir.mapsa.springatm.mappers;

import ir.mapsa.springatm.dto.TransactionDTO;
import ir.mapsa.springatm.entities.Transaction;
import ir.mapsa.springatm.entities.Transaction.TransactionBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-09T00:48:57+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(TransactionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransactionBuilder transaction = Transaction.builder();

        return transaction.build();
    }

    @Override
    public TransactionDTO toDto(Transaction entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        return transactionDTO;
    }

    @Override
    public List<Transaction> toEntities(List<TransactionDTO> dtoes) {
        if ( dtoes == null ) {
            return null;
        }

        List<Transaction> list = new ArrayList<Transaction>( dtoes.size() );
        for ( TransactionDTO transactionDTO : dtoes ) {
            list.add( toEntity( transactionDTO ) );
        }

        return list;
    }

    @Override
    public List<TransactionDTO> toDtoes(List<Transaction> entites) {
        if ( entites == null ) {
            return null;
        }

        List<TransactionDTO> list = new ArrayList<TransactionDTO>( entites.size() );
        for ( Transaction transaction : entites ) {
            list.add( toDto( transaction ) );
        }

        return list;
    }

    @Override
    public void update(Transaction entity, TransactionDTO dto) {
        if ( dto == null ) {
            return;
        }
    }
}

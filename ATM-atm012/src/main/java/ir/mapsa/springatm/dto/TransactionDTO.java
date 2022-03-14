package ir.mapsa.springatm.dto;

import ir.mapsa.springatm.entities.Account;
import ir.mapsa.springatm.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long id;
    private Double amount;
    private Account account;
    private TransactionType type;
    private Date date;
}

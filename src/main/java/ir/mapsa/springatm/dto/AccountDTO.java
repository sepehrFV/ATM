package ir.mapsa.springatm.dto;


import ir.mapsa.springatm.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long accountNumber;

    @Min(100)
    private Double balance;

    private Person person;


}

package ir.mapsa.springatm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @NotNull
    @Size(min = 3, max = 10)
    private String name;

    @NotNull
    @Size(min = 3, max = 10)
    private String family;

    @Min(10)
    @Max(10)
    @NotNull
    private String national_ID;

    @Min(18)
    @NotNull
    private Integer age;
}

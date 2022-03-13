package ir.mapsa.springatm.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

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

    private String username;

    @Min(18)
    @NotNull
    private Integer age;
}

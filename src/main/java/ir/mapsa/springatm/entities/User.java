package ir.mapsa.springatm.entities;

import ir.mapsa.springatm.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_name")
    @Size(min = 3,max = 10)
    private String name;

    @Column(name = "u_family")
    @Size(min = 3,max = 10)
    private String family;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_national_ID")
    @Size(min = 10,max = 10)
    private String national_ID;

    @Column(name = "u_age")
    @Min(18)
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Roles role;


}


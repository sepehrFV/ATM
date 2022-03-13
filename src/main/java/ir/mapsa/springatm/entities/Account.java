package ir.mapsa.springatm.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
@Builder
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_acount_number")
    private Long accountNumber;

    @Column(name = "a_balance")
    @Min(100)
    private Double balance;

    @Column(name = "a_password")
    @Size(min = 4,max = 10)
    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "p_id")
    @NotNull
    private User user;


}

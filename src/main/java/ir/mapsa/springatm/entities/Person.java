package ir.mapsa.springatm.entities;

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
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_name")
    @Size(min = 3,max = 10)
    private String name;

    @Column(name = "p_family")
    @Size(min = 3,max = 10)
    private String family;

    @Column(name = "p_national_ID")
    @Min(10)
    private String national_ID;


    @Column(name = "p_age")
    @Min(18)
    private Integer age;


}


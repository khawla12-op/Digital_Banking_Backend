package enset.ma.digitalbankingbackend.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer" )
    //Pour evite la dependance circulaire (des relations biredictionnelles)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<BankAccount> bankAccounts;


}

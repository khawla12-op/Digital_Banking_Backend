package enset.ma.digitalbankingbackend.repositories;

import enset.ma.digitalbankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {


}

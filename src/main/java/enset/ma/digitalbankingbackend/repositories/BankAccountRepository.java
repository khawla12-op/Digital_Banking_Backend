package enset.ma.digitalbankingbackend.repositories;

import enset.ma.digitalbankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}

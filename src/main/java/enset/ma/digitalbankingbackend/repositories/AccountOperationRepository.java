package enset.ma.digitalbankingbackend.repositories;

import enset.ma.digitalbankingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, String> {
//    Page<Operation> findByAccountId(String accountId, Pageable pageable);

}

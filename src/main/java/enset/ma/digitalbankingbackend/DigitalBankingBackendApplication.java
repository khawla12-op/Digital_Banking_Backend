package enset.ma.digitalbankingbackend;

import enset.ma.digitalbankingbackend.dtos.CustomerDTO;
import enset.ma.digitalbankingbackend.entities.*;
import enset.ma.digitalbankingbackend.enums.AccountStatus;
import enset.ma.digitalbankingbackend.enums.OperationType;
import enset.ma.digitalbankingbackend.exceptions.CustomerNotFoundException;
import enset.ma.digitalbankingbackend.repositories.BankAccountRepository;
import enset.ma.digitalbankingbackend.repositories.CustomerRepository;
import enset.ma.digitalbankingbackend.repositories.AccountOperationRepository;
import enset.ma.digitalbankingbackend.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("khaoula", "Smail", "Mohamed").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random() * 90000, 9000, customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random() * 120000, 5.5, customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccount> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccount bankAccount : bankAccounts) {
                for (int i = 0; i < 10; i++) {
                    String accountId;
                    if (bankAccount instanceof SavingAccount) {
                        accountId = ((SavingAccount) bankAccount).getId();
                    } else {
                        accountId = ((CurrentAccount) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId, 10000 + Math.random() * 120000, "Credit");
                    bankAccountService.debit(accountId, 1000 + Math.random() * 9000, "Debit");
                }
            }


        };
    }
}



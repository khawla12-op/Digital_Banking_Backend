package enset.ma.digitalbankingbackend.services;

import enset.ma.digitalbankingbackend.dtos.BankAccountDTO;
import enset.ma.digitalbankingbackend.dtos.CurrentBankAccountDTO;
import enset.ma.digitalbankingbackend.dtos.CustomerDTO;
import enset.ma.digitalbankingbackend.dtos.SavingBankAccountDTO;
import enset.ma.digitalbankingbackend.entities.BankAccount;
import enset.ma.digitalbankingbackend.entities.CurrentAccount;
import enset.ma.digitalbankingbackend.entities.Customer;
import enset.ma.digitalbankingbackend.entities.SavingAccount;
import enset.ma.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import enset.ma.digitalbankingbackend.exceptions.BankAccountNotFoundException;
import enset.ma.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overdraft, Long customerId) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount> bankAccountList();


    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}

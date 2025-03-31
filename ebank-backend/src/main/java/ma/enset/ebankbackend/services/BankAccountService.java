package ma.enset.ebankbackend.services;

import jakarta.transaction.Transactional;
import ma.enset.ebankbackend.dtos.*;
import ma.enset.ebankbackend.entities.BankAccount;
import ma.enset.ebankbackend.entities.CurrentAccount;
import ma.enset.ebankbackend.entities.Customer;
import ma.enset.ebankbackend.entities.SavingAccount;
import ma.enset.ebankbackend.exceptions.BalanceNotFoundException;
import ma.enset.ebankbackend.exceptions.BankAccountNotFoundException;
import ma.enset.ebankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

@Transactional
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overdraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotFoundException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BalanceNotFoundException, BankAccountNotFoundException;
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    List<BankAccountDTO> bankAccountList();

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}

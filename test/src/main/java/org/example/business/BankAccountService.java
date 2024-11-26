package org.example.business;

import org.example.exception.AccountNotFoundException;
import org.example.exception.BalanceNotSufficientException;
import org.example.model.BankAccount;

import java.util.List;
import java.util.function.Predicate;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount bankAccount);
    List<BankAccount> getAllAccounts();
    BankAccount getBankAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void creditAccount(String accountId, double amount);
    void debitAccount(String accountId, double amount) throws BalanceNotSufficientException;
    void transfert(String accountSource, String accountDestination, double amount) throws BalanceNotSufficientException;
    List<BankAccount> getSavingAccounts();
    List<BankAccount> getCurrentAccounts();
    double getTotalBalance();
    //List<BankAccount> searchAccount(Condition condition);
    List<BankAccount> searchAccount(Predicate<BankAccount> filter);
}

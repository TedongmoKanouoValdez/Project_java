package org.example.business;

import org.example.exception.AccountNotFoundException;
import org.example.exception.BalanceNotSufficientException;
import org.example.model.AccountStatus;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService {
    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return bankAccount;
    }


    @Override
    public List<BankAccount> getAllAccounts() {
       return bankAccounts;
    }

    @Override
    public BankAccount getBankAccountById(String id) throws AccountNotFoundException {
      // Declarative approche
      return bankAccounts
               .stream()
               .filter(acc->acc.getAccountId().equals(id))
               .findFirst().orElseThrow(()-> new AccountNotFoundException(String.format("BankAccount %s not found", id)));

       // Imperative approche
        /* for(BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountId().equals(id)) {
                return bankAccount;
            }
        }
        throw  new AccountNotFoundException("BankAccount is not found");
        */
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            BankAccount bankAccount ;
            //expression ternaire
            if(Math.random() > 0.5) {
                bankAccount = new CurrentAccount(Math.random()>0.5 ? "MAD": "USD", Math.random()*100000, Math.random()*500000 );
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            else{
                bankAccount = new SavingAccount(Math.random()>0.5?"MAD":"USD", Math.random()*100000, 3*Math.random()*500000 );
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccounts.add(bankAccount);
        }
    }

    @Override
    public void creditAccount(String accountId, double amount) throws AccountNotFoundException {
        BankAccount bankAccountById = getBankAccountById(accountId);
        bankAccountById.setBalance(bankAccountById.getBalance()+amount);
    }

    @Override
    public void debitAccount(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccount bankAccountById = getBankAccountById(accountId);
        if(amount > bankAccountById.getBalance()) throw new BalanceNotSufficientException("Balance not suficient");
            bankAccountById.setBalance(bankAccountById.getBalance()-amount);
    }

    @Override
    public void transfert(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException{
        debitAccount(accountSource,amount);
        creditAccount(accountDestination,amount);
    }

    @Override
    public List<BankAccount> getSavingAccounts() {

        //declarative approche
        List<BankAccount> collect = bankAccounts.stream()
                .filter(bankAccount -> bankAccount instanceof SavingAccount)
               .collect(Collectors.toList());
       return collect;

       /*
        //imperative approche
        List<BankAccount> result = new ArrayList<>();
        for(BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getType().equals("SAVING ACCOUNT")) {
                result.add(bankAccount);
            }
        }
        return result; */
    }

    @Override
    public List<BankAccount> getCurrentAccounts() {
        List<BankAccount> collect = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getType().equals("CURRENT ACCOUNT"))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public double getTotalBalance() {
        return bankAccounts
                .stream()
                .map(bankAccount -> bankAccount.getBalance())
                .reduce(0.0, Double::sum);
/*
double somme = 0;

        for(BankAccount bankAccount : bankAccounts) {
            somme += bankAccount.getBalance();
        }
        return somme; */
    }

    @Override
    public List<BankAccount>searchAccount(Predicate<BankAccount> filter){
        List<BankAccount> result = new ArrayList<>();
        for(BankAccount bankAccount : bankAccounts) {
            if(filter.test(bankAccount)) {
                result.add(bankAccount);
            }
        }
        return result;
    }
}

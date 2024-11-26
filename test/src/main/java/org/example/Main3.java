package org.example;

import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImpl;
import org.example.business.Condition;
import org.example.exception.AccountNotFoundException;
import org.example.exception.BalanceNotSufficientException;
import org.example.model.AccountStatus;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;
import org.example.utils.DataTransformationUtils;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandomData(10);
        BankAccount bankAccount1 = new CurrentAccount("MAD", 32000, 100);
        bankAccount1.setAccountId("CC1");
        BankAccount bankAccount2 = new SavingAccount("MAD", 1000, 3.2);
        bankAccount2.setAccountId("CC2");
        bankAccountService.addBankAccount(bankAccount1);
        bankAccountService.addBankAccount(bankAccount2);

       /* bankAccountService.getAllAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

        */
        try{
            BankAccount acc1 = bankAccountService.getBankAccountById("CC1");
            BankAccount acc2 = bankAccountService.getBankAccountById("CC2");
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));
            System.out.println("***************");
            bankAccountService.debitAccount(acc1.getAccountId(), 2000);

            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println("***************");
            bankAccountService.transfert(acc1.getAccountId(), acc2.getAccountId(), 3000);
            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("***************");
        System.out.println("+++++++++++++++++++++++");

        bankAccountService.getSavingAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
        ;
        System.out.println("***************");
        System.out.println("Total Balance: " + bankAccountService.getTotalBalance());

        // expression lamba de l'interface
        List<BankAccount> bankAccounts = bankAccountService.searchAccount(account -> (account.getStatus() == AccountStatus.SUSPENDED));
        bankAccounts.stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
    }
}

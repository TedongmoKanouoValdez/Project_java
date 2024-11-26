package org.example;

import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImpl;
import org.example.exception.AccountNotFoundException;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addBankAccount(new CurrentAccount("EUR",70, 20));
        bankAccountService.addBankAccount(new SavingAccount("USD",100, 100));
        BankAccount bankAccount = new CurrentAccount("EUR", 299,200);
        bankAccount.setAccountId("CC1");
        List<BankAccount> allAccount = bankAccountService.getAllAccounts();

        /* for(int i=0; i<allAccount.size(); i++){
            System.out.println(allAccount.get(i).toString());
        }

        for (BankAccount bankAccount : allAccount) {
            System.out.println(bankAccount);
        }*/

        /*programmation fonctionnelle
        allAccount.forEach(new Consumer<BankAccount>() {
            public void accept(BankAccount bankAccount) {
                System.out.println(bankAccount);
            }
        });*/

        //expression lamda
        allAccount.forEach((account) -> {
            System.out.println(account);
        });

        System.out.println("*********");
        BankAccount accountById = null;
        try{
            accountById = bankAccountService.getBankAccountById("CC1");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //System.out.println(accountById.toString());

        System.out.println("*********");
        System.out.println("*** Suite du programme ***");
    }
}

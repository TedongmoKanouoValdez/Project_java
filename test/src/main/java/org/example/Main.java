package org.example;

import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String s1 = new String("'valdez'");
        String s2 = new String("'valdez'");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("********************");

        CurrentAccount bankAccount = new CurrentAccount();
        //bankAccount.setAccountId("1");
        bankAccount.setBalance(300);
        bankAccount.setCurrency("EUR");

        printAccount(bankAccount);

        SavingAccount bankAccount2 = new SavingAccount("300", 1200, 15);
        printAccount(bankAccount2);

    }

    public static void printAccount(SavingAccount account) {
        System.out.println("********* Saving Account ****************");
        System.out.println("Id du compte = " + account.getAccountId());
        System.out.println("la balance de ce compte = " + account.getBalance());
        System.out.println("la devise du compte =" + account.getCurrency());
        System.out.println("Son status est  " + account.getStatus());
        System.out.println("le taux d'interet est de : " + account.getInterestRate());
        System.out.println("le type de compte : " + account.getType());

        System.out.println("*************************");

        System.out.println(account);
    }

    public static void printAccount(CurrentAccount account) {
        System.out.println("********** Currency Account ***************");
        System.out.println("Id du compte = " + account.getAccountId());
        System.out.println("la balance de ce compte = " + account.getBalance());
        System.out.println("la devise du compte =" + account.getCurrency());
        System.out.println("Son status est  " + account.getStatus());
        System.out.println("la decouverte est de : " + account.getOverdraft());
        System.out.println("le type de compte : " + account.getType());
        System.out.println("*************************");

        System.out.println(account);
    }
}
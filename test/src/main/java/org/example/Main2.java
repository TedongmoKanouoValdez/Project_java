package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

public class Main2 {
    public static void main(String[] args) throws JsonProcessingException {
        CurrentAccount[] accounts = new CurrentAccount[2];
        SavingAccount[] savingAccounts = new SavingAccount[2];

        accounts[0] = new CurrentAccount("USD", 500.00, 200);
        accounts[1] = new CurrentAccount("EUR", 100.00, 100);
        savingAccounts[0] = new SavingAccount("GBP", 200.00, 18);
        savingAccounts[1] = new SavingAccount("CHF", 300.00, 10);

        System.out.println("**** les tableaux *****");

        for (BankAccount account : accounts) {
            if(account instanceof CurrentAccount) {
               System.out.println (((CurrentAccount) account).getType());
            }
            else if (account instanceof SavingAccount) {
                System.out.println(((SavingAccount) account).getType());
            }
            System.out.println(account.getType());
        }

         for(int i = 0; i < accounts.length; i++){
            System.out.println(accounts[i].toString());
        }

        System.out.println("***** les listes ********");

        List<BankAccount> accountList = new ArrayList<BankAccount>();
        accountList.add(new CurrentAccount("USD", 500.00, 10));
        accountList.add(new CurrentAccount("EUR", 100.00, 10));
        accountList.add(new CurrentAccount("GBP", 200.00, 50));
        accountList.add(new SavingAccount("CHF", 300.00, 20));
        accountList.add(new SavingAccount("USD", 500.00, 67));

        for (BankAccount account : accountList) {
            System.out.println(account.getBalance());
        }

        System.out.println("***** les collections avec Map *****");

        Map<String, CurrentAccount> bankAccountMap = new HashMap<>();
        bankAccountMap.put("cc1", new CurrentAccount("USD", 500.00, 89));
        bankAccountMap.put("cc2", new CurrentAccount("EUR", 100.00, 9));
        bankAccountMap.put("cc3", new CurrentAccount());

        BankAccount account = bankAccountMap.get("cc1");
        System.out.println(bankAccountMap.toString());

        System.out.println("***** Parcourir les cles *****");
        for (String key : bankAccountMap.keySet()) {
            System.out.println(bankAccountMap.get(key));
        }

        System.out.println("***** Parcourir les valeurs *****");
        for (BankAccount ba : bankAccountMap.values()) {
            System.out.println(ba);
        }
        System.out.println("****** le format Json **");
        for (BankAccount ba : bankAccountMap.values()) {
            System.out.println(toJson(ba));
        }
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
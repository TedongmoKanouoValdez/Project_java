package org.example.model;

import java.util.UUID;

public abstract class BankAccount extends Object{
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public BankAccount(){
        this.accountId = UUID.randomUUID().toString();
        this.status = AccountStatus.SUSPENDED;
    }

    public BankAccount(String currency, double initialBalance){
        this();
        this.currency = currency;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String toString(){
        return "BAnkAccount [" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", currency=" + currency +
                ", status=" + status + " ]";
    }

    public abstract String getType();
}


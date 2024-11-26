package org.example.model;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount() {
        super();
    }
    public SavingAccount(String currency, double initialBalance ,double interestRate) {
        super(currency, initialBalance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String toString() {
        return "SavingAccount, interestRate=" + interestRate + super.toString();
    }

    @Override
    public String getType() {
        return "SavingAccount";
    }
}

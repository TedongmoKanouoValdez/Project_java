package org.example.model;

public class CurrentAccount extends BankAccount {
    private double overdraft;


    public CurrentAccount() {
        super();
        this.overdraft = overdraft;
    }
    public CurrentAccount(String currency, double initialBalance,double overdraft) {
        super(currency, initialBalance);
        this.overdraft = overdraft;
    }
    public String toString(){
        return "Current Account: " + super.toString() +
                "\nOverdraft: " + overdraft;
    }

    @Override
    public String getType() {
        return "Current Account";
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}

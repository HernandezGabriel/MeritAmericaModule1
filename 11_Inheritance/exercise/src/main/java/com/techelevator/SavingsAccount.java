package com.techelevator;

public class SavingsAccount extends BankAccount{

    //Constructors
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int fee=2;
        int minimumBalance=150;
        if((getBalance()-(amountToWithdraw+fee))<0){
            return super.withdraw(0);
        }
        else if((getBalance()-amountToWithdraw)<minimumBalance){
            return super.withdraw((amountToWithdraw+fee));
        }

        else{
            return super.withdraw(amountToWithdraw);

    }}
}

package com.techelevator;

public class CheckingAccount extends BankAccount{

    //Constructors
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int fee=10;
        int minimumBalance=-100;
        if ((getBalance()-amountToWithdraw)<0&&(getBalance()-amountToWithdraw)>(minimumBalance)){
            return super.withdraw((amountToWithdraw+fee));
        }
        else if((getBalance()-amountToWithdraw)<minimumBalance){
            return super.withdraw(0);
        }
        else if((getBalance()-amountToWithdraw)>=0){
            return super.withdraw(amountToWithdraw);
        }
        return super.withdraw(amountToWithdraw);


    }
}

package com.techelevator;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//Correct? why return array and not list?


    public Accountable[] getAccounts() {
        //return (Accountable[])accounts.toArray();
        int size =accounts.size();
        Accountable[] accountsArray= new Accountable[size];
        int index=0;
        for (Accountable a: accounts) {
            accountsArray[index]=a;
            index++;
        }
        return accountsArray;

    }

    public void addAccount(Accountable newAccount){
        if(newAccount!=null) {
            accounts.add(newAccount);
        }
    }

    public boolean isVip(){
        int balance=0;
        for (Accountable a: accounts) {
            balance+=a.getBalance();
        }
        if (balance>=25000){
            return true;
        }
        else {
            return false;
        }
    }
}

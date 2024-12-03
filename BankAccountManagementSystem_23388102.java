import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;



public class BankAccountManagementSystem_23388102 {
    private String accountNumber;
    private double balance;
    private String accountHolder;
    private static ArrayList<BankAccountManagementSystem_23388102> accounts = new ArrayList<>();


    // Constructor to create an account
    public BankAccountManagementSystem_23388102(String accountNumber, String accountHolder, double initialBalance) {


            if (isDuplicateAccount(accountNumber)) {
                this.accountNumber = null;
                this.balance = 0.0;
            } else {
                this.accountNumber = accountNumber;
            }

            this.accountHolder = accountHolder;
            if (initialBalance < 0) {
                this.balance = 0;
            } else {
                this.balance = initialBalance;
            }
            accounts.add(this);
        }


    public BankAccountManagementSystem_23388102() {
        this.accountNumber = "0001";
        this.accountHolder = "John Doe";
        this.balance = 100;
    }


    private boolean isDuplicateAccount(String accountNumber) {
        for (BankAccountManagementSystem_23388102 account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit (double amount) {
        if (amount <= 0) {
            System.out.println("Invalid input");
        } else {
            this.balance += amount;
        }
    }
    public double getBalance() {
        return balance;
    }



}




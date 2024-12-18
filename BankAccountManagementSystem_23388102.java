import org.junit.jupiter.api.Test;

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

    public void withdraw (double amount) {
        if (amount > this.getBalance()) {
            System.out.println("Withdrawal amount cannot exceed balance");
        }
        else {
            if (amount <= 0 || this.getBalance() - amount < 0) {
                System.out.println("Invalid input");
            } else {
                this.balance -= amount;
            }
        }
    }

    public String inquireBalance() {
        if (this.accountNumber == null || this.balance < 0) {
            return "Account not found or balance invalid.";
        }
        return String.format("Account: %s | Balance: %.2f", this.accountNumber, this.balance);
    }





}





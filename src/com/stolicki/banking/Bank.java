package com.stolicki.banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public static void main(String[] args) {
        Bank bank = new Bank("bank");

        bank.addBranch("branch1");

        bank.addCustomer("branch1", "customer1", 100.10);
        bank.addCustomer("branch1", "customer2", 200.20);
        bank.addCustomer("branch1", "customer3", 300.30);

        bank.addCustomerTransaction("branch1", "customer1", 100.10);
        bank.addCustomerTransaction("branch1", "customer2", 200.20);
        bank.addCustomerTransaction("branch1", "customer3", 300.30);

        bank.listCustomers("branch1", true);
    }

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i <= this.branches.size() - 1; i++) {
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        if (findBranch(branchName) != null) {
            if (findBranch(branchName).getCustomers().size() == 0) {
                findBranch(branchName).newCustomer(customerName, initialTransaction);
                return true;
            }
            for (int i = 0; i <= findBranch(branchName).getCustomers().size() - 1; i++) {
                if (findBranch(branchName).getCustomers().get(i).getName().equals(customerName)) {
                    return false;
                } else if (i == findBranch(branchName).getCustomers().size() - 1) {
                    findBranch(branchName).newCustomer(customerName, initialTransaction);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double initialTransaction) {
        if (findBranch(branchName) != null) {
            for (int i = 0; i <= findBranch(branchName).getCustomers().size() - 1; i++) {
                if (findBranch(branchName).getCustomers().get(i).getName().equals(customerName)) {
                    findBranch(branchName).getCustomers().get(i).addTransaction(initialTransaction);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransaction) {
        if (findBranch(branchName) != null) {
            if (printTransaction) {
                System.out.println("Customer details for branch " + branchName);
                for (int i = 0; i <= findBranch(branchName).getCustomers().size() - 1; i++) {
                    System.out.println("Customer: " + findBranch(branchName).getCustomers().get(i).getName() + "[" + (i + 1) + "]");
                    System.out.println("Transactions");
                    for (int j = 0; j <= findBranch(branchName).getCustomers().get(i).getTransactions().size() - 1; j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + findBranch(branchName).getCustomers().get(i).getTransactions().get(j));
                    }
                }
                return true;
            } else {
                System.out.println("Customer details for branch " + branchName);
                for (int i = 0; i <= findBranch(branchName).getCustomers().size() - 1; i++) {
                    System.out.println("Customer: " + findBranch(branchName).getCustomers().get(i).getName() + "[" + (i + 1) + "]");
                }
                return true;
            }
        }
        return false;
    }
}
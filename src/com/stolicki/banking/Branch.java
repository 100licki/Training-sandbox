package com.stolicki.banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i <= customers.size() - 1; i++) {
            if (this.customers.get(i).getName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        if (findCustomer(name) == null) {
            Customer newCustomer = new Customer(name, initialTransaction);
            this.customers.add(newCustomer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        if (findCustomer(name) != null) {
            findCustomer(name).addTransaction(transaction);
            return true;
        } else {
            return false;
        }
    }
}

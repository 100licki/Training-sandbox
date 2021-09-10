package com.stolicki.concurrency.challenges;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00, "1234ti");

        new Thread(() -> {
            account.deposit(300.00);
            System.out.println("balance after deposit1 = " + account.getBalance());
            account.withdraw(50.00);
            System.out.println("balance after withdraw1 = " + account.getBalance());
        }).start();

        new Thread(() -> {
            account.deposit(203.75);
            System.out.println("balance after deposit2 = " + account.getBalance());
            account.withdraw(100.00);
            System.out.println("balance after withdraw2 = " + account.getBalance());
        }).start();
    }
}

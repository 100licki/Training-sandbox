package com.stolicki.concurrency.deadlocks;

public class Deadlock {
    public static void main(String[] args) {
        final PolitePerson jane = new PolitePerson("jane");
        final PolitePerson john = new PolitePerson("john");

        new Thread(() -> jane.sayHello(john)).start();

        new Thread(() -> john.sayHello(jane)).start();
    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}

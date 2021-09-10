package com.stolicki.concurrency.threadsIntoduction;

import static com.stolicki.concurrency.threadsIntoduction.ThreadColor.*;

public class main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Main Thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Anonymous Thread")).start();

        Thread myRunnableThread =  new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "anonymous class implementation run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "Another Thread terminated or timed out");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_BLUE + "Main Thread again");


    }
}

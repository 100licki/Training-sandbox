package com.stolicki.concurrency.threadsIntoduction;

import static com.stolicki.concurrency.threadsIntoduction.ThreadColor.ANSI_BLUE;
import static com.stolicki.concurrency.threadsIntoduction.ThreadColor.ANSI_RED;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_RED + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "3 seconds have passed");
    }
}

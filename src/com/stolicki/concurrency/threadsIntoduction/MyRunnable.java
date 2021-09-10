package com.stolicki.concurrency.threadsIntoduction;

import static com.stolicki.concurrency.threadsIntoduction.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "MyRunnable Thread");
    }
}

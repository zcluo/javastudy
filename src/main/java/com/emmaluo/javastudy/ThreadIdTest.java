package com.emmaluo.javastudy;

import java.util.Date;

/**
 * Created by zcluo on 2017/3/6.
 */
public class ThreadIdTest {
     class ThreadLocalValuePrinter
            implements Runnable {
        int pauseTime;


        public ThreadLocalValuePrinter(int x) {
            pauseTime = x;


        }
        public void run() {
            while(true) {
                try {
                    System.out.println("Thread name is " +  Thread.currentThread().getName() + "; Thread local value is " + ThreadId.get() + "; Timestamp is " + new
                            Date(System.currentTimeMillis()));

                    Thread.sleep(pauseTime);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
        }

    }

    public void run(){
        Runnable r1 = new ThreadLocalValuePrinter(500);

        Thread t1 = new Thread(r1);

        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();
        Thread t3 = new Thread(r1);
        t3.start();
    }



    static public void main(String[] args){
        ThreadIdTest threadIdTest  = new ThreadIdTest();
        threadIdTest.run();


    }
}

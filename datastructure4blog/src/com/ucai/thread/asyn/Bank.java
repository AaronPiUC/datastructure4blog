package com.ucai.thread.asyn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements Runnable{
    private int tickets = 100;
    private ReentrantLock myLock = new ReentrantLock();
    /*@Override
    public void run() {
        myLock.lock();
        try{
            Condition con = myLock.newCondition();
            System.out.println(con);
            while(tickets > 0){
                System.out.println(Thread.currentThread().getName()+"售出第"+tickets);
                tickets = tickets -1;
            }
        }finally {
            myLock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"窗口票已售完");
    }*/

    /*@Override
    public synchronized void run() {
        while(tickets > 0){
            System.out.println(Thread.currentThread().getName()+"售出第"+tickets);
            tickets = tickets -1;
        }

        System.out.println(Thread.currentThread().getName()+"窗口票已售完");
    }*/

    @Override
    public void run() {
        synchronized (this){
            while(tickets > 0){
                System.out.println(Thread.currentThread().getName()+"售出第"+tickets);
                tickets = tickets -1;
            }

            System.out.println(Thread.currentThread().getName()+"窗口票已售完");
        }

    }

    public static void main(String []args) {
        Bank b = new Bank();
        for (int i = 0; i < 5; i++) {
            new Thread(b,"线程"+i).start();
        }
    }
}

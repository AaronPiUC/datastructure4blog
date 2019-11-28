package com.ucai.thread.asyn;

import java.util.concurrent.locks.ReentrantLock;

public class Bank implements Runnable{
    private int tickets = 100;
    private ReentrantLock myLock = new ReentrantLock(true);
    @Override
    public void run() {

        while(tickets > 0){
            try{
                myLock.lock();
                    if(tickets > 0){
                        System.out.println(Thread.currentThread().getName()+"售出第"+tickets);
                        tickets = tickets -1;
                }
            }finally {
                myLock.unlock();
            }
        }

        System.out.println(Thread.currentThread().getName()+"窗口票已售完");
    }
    public static void main(String []args) {
        Bank b = new Bank();
        for (int i = 0; i < 5; i++) {
            new Thread(b,"线程"+i).start();
        }
    }
}

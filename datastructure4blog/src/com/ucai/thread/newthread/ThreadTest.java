package com.ucai.thread.newthread;

public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("thread run");
    }

    public static void main(String[] args) {
        ThreadTest th = new ThreadTest();
        th.start();
    }
}


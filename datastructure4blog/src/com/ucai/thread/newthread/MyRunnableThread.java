package com.ucai.thread.newthread;

public class MyRunnableThread implements Runnable{

    @Override
    public void run(){
        System.out.println("Runnable Thread !");
        Thread.interrupted();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("t:"+t+"e:"+e.getMessage());
    }
}
class MyRunnableTest{
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        Thread thread = new Thread(new MyRunnableThread());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
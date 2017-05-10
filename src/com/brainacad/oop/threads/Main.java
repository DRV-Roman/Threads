package com.brainacad.oop.threads;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            MyThread myThread = new MyThread();//first way to create a thread
            myThread.setDaemon(false);//true - приложение не ждет завершения потоков
            myThread.start();
          //  myThread.interrupt();
        }

       /* Thread thread = new Thread(new MyRunnable());//second way to create a thread
        thread.setName("Test");
        thread.setPriority(10);
        thread.setDaemon(false);
        thread.start();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getState());

        thread.interrupt();*/
    }
}

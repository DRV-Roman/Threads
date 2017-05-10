package com.brainacad.oop.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample {

    static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(lock.isLocked());
                lock.lock();//блокируется данная переменная для доступа другим потокам до следующего unlock
                //при попытке заблокировать данную переменную из другого потока - другой поток заблокируется до момента
                //unlock
                System.out.println("Thread1 locked");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread1 unlocked");
                lock.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(lock.isLocked());
                lock.lock();
                System.out.println("Thread2 locked");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread2 unlocked");
                lock.unlock();
            }
        }).start();

    }

}

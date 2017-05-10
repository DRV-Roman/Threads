package com.brainacad.oop.threads;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable "+Thread.currentThread().getName());
    }
}

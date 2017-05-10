package com.brainacad.oop.threads;

public class VolatileSample {
    static volatile int val = 0;//volatile makes variable global (to be seen from all threads)

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int localVal = val;
                while (localVal < 5) {
                    if (localVal != val) {
                        System.out.println("Local val=" + val);
                        localVal = val;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int localVal = val;
                while (val < 5) {
                    System.out.println("Increment val to " + (localVal + 1));
                    val = ++localVal;

                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}

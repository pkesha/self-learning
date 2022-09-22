package com.keshavarziparham;

public class Main {

    public static void main(String[] args) {
        //From lecture 268 - Thread variables
//        Countdown countdown = new Countdown();
//
//        CountdownThread t1 = new CountdownThread(countdown);
//        t1.setName("Thread 1");
//        CountdownThread t2 = new CountdownThread(countdown);
//        t2.setName("Thread 2");
//
//        t1.start();
//        t2.start();

        //Lecture 269 - Synchronization

        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown2);
        t2.setName("Thread 2");

        t1.start();
        t2.start();


    }
}

class Countdown{
    //All threads will now share the same value of i, have to declare it in for loop
    private int i;

    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
                break;
        }

        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}


class CountdownThread extends Thread{
    private Countdown threadCountDown;

    public CountdownThread(Countdown countdown){
        threadCountDown = countdown;
    }

    public void run(){
        threadCountDown.doCountdown();
    }
}
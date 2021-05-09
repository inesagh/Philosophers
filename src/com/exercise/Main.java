package com.exercise;

public class Main {
    public static void main(String[] args) {
        Fork[] fork = new Fork[5];
        EachPhilosopher[] eachPhilosopher = new EachPhilosopher[5];
        for (int i = 0; i < 5; i++) {
            fork[i] = new Fork();
        }
        for (int i = 0; i < 5; i++) {
            if (i == 1) {
                eachPhilosopher[i] = new EachPhilosopher(fork[(i + 1) / 5], fork[i], "Philosopher " + (i + 1));
            } else {
                eachPhilosopher[i] = new EachPhilosopher(fork[i], fork[(i + 1) / 5], "Philosopher " + (i + 1));
            }
            Thread thread = new Thread(eachPhilosopher[i]);
            thread.start();
        }


    }
}

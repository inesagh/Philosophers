package com.exercise;

public class EachPhilosopher implements Runnable {
    private Fork left;
    private Fork right;
    private String position;

    public EachPhilosopher(Fork left, Fork right, String position) {
        this.left = left;
        this.right = right;
        this.position = position;
    }


    @Override
    public void run() {
        think();
        acquireFork();
    }

    public void acquireFork() {
        while (true) {
            synchronized (left) {
                System.out.println(position + " -> left fork ");
                synchronized (right) {
                    System.out.println(position + " -> right fork ");
                    eat();
                    think();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void eat() {
        System.out.println(position + " is eating. ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(position + " finished eating");
    }

    public void think() {
        System.out.println(position + " is thinking. ");
    }


}

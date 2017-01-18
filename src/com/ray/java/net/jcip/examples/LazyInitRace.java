package com.ray.java.net.jcip.examples;

import net.jcip.annotations.*;

import java.util.concurrent.CountDownLatch;

/**
 * LazyInitRace
 * <p>
 * Race condition in lazy initialization
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class LazyInitRace {
    private static ExpensiveObject instance = null;

    public synchronized static ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }

    public static void main(String[] args) {
        int count = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                getInstance();
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("instance count=" + ExpensiveObject.getInstanceCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExpensiveObject {
    static int sInstanceCount;

    ExpensiveObject() {
        super();
        System.out.println("getInstance");
        sInstanceCount++;
    }

    public static int getInstanceCount() {
        return sInstanceCount;
    }
}


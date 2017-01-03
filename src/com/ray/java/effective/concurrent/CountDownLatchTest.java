package com.ray.java.effective.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class CountDownLatchTest {
    private static CountDownLatch sCountDownLatch;

    public static void main(String[] args) {
        final int thread_count = 20;
        sCountDownLatch = new CountDownLatch(thread_count);
        for (int i = 0; i < thread_count; i++) {
            new Thread(() -> {
                System.out.println(String.format("%s,print", Thread.currentThread().getName()));
                sCountDownLatch.countDown();
            }, String.format("thread[%d]", i)).start();
        }

        try {
            sCountDownLatch.await();//等待计数器执行完成
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

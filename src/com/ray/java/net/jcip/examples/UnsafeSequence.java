package com.ray.java.net.jcip.examples;

import com.ray.java.utils.Preconditions;

import net.jcip.annotations.NotThreadSafe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    //如果是线程安全的那么，两个list的size都是一样的
    private static Set<Integer> resultSet = new HashSet<>();
    private static List<Integer> resultList = new ArrayList<>();


    /**
     * Returns a unique value.
     */
    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                int next = unsafeSequence.getNext();
                resultSet.add(next);
                resultList.add(next);
                System.out.println(next);
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            //如果没有加锁肯定会抛出异常,加锁就是正确的。测试结果也是这样
            Preconditions.checkArgument(resultList.size() == resultSet.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

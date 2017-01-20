package com.ray.java.net.jcip.examples;

import com.ray.java.utils.Preconditions;

/**
 * 测试ThreadLocal
 *
 *
 * 测试结果：ThreadLocal能维护线程的内部变量
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> mShareStr = new ThreadLocal<>();
//    private static String mShareStr;

    public static void main(String[] args) {
        int threadCount = 1500;

        for (int i = 0; i < threadCount; i++) {
            final int temp = i;
            new Thread(() -> {
                //线程安全使用ThreadLocal
                mShareStr.set("str" + temp);
                String cur = mShareStr.get();
                String log = String.format("%s val=%s", Thread.currentThread().getName(), cur);

                //非线程安全
//                mShareStr = "str" + temp;
//                String cur = mShareStr;
//                String log = String.format("%s val=%s", Thread.currentThread().getName(), cur);

                System.out.println(log);
                Preconditions.checkArgument(Thread.currentThread().getName().equals(cur));
            }, "str" + i).start();
        }
    }
}

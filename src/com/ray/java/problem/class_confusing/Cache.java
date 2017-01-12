package com.ray.java.problem.class_confusing;

/**
 * Created by 80107442 on 2017-01-11.
 */
public class Cache {
    static {
        initializeIfNecessary();
    }

    private static int sum;

    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }

    //这里又被重新初始化了
    private static boolean initialized = false;

    private static synchronized void initializeIfNecessary() {
        if (!initialized) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            initialized = true;
        }
    }
}

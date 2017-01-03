package com.ray.java.effective.concurrent.lazy;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class TestManager {
    //第一种初始化方法
    //耗时:394684ns
    /**
    private static TestManager sInstance;

    public static TestManager getInstance() {
        if (null == sInstance) {
            synchronized (TestManager.class) {
                if (null == sInstance) {
                    sInstance = new TestManager();
                }
            }
        }
        return sInstance;
    }

    private TestManager() {
    }
     */

    //第二种初始化方法
    //耗时:452845ns
    /**
    private static volatile TestManager sInstance;

     public static TestManager getInstance() {
     if (null == sInstance) {
     synchronized (TestManager.class) {
     if (null == sInstance) {
     sInstance = new TestManager();
     }
     }
     }
     return sInstance;
     }

     private TestManager() {
     }
     */

    //第三种初始化方法
    //耗时:413346ns
    /**
    private static volatile TestManager sInstance;

    public static TestManager getInstance() {
        TestManager testManager = sInstance;
        if (null == testManager) {
            synchronized (TestManager.class) {
                if (null == testManager) {
                    sInstance = testManager = new TestManager();
                }
            }
        }
        return testManager;
    }

    private TestManager() {
    }*/


    //lazy 初始化


    private static class Holder{
        static TestManager sInstance = new TestManager();
    }

    public static TestManager getInstance() {
        return Holder.sInstance;
    }

    private TestManager() {
    }
}

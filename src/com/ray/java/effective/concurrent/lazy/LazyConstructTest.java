package com.ray.java.effective.concurrent.lazy;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class LazyConstructTest {
    private static TestManager mTestManager ;
    public static void main(String[] args){
        long beginTime = System.nanoTime();
        mTestManager = TestManager.getInstance();
        System.out.println(String.format("wasteTime[%d]",(System.nanoTime() - beginTime)));
    }
}

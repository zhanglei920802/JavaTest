package com.ray.java.problem.class_confusing;

/**
 * Created by 80107442 on 2017-01-11.
 */
public class Client {
    public static void main(String[] args) {
        int sum = Cache.getSum();
        assert sum == 9900;
        System.out.println(sum);
    }
}

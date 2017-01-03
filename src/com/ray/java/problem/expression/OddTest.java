package com.ray.java.problem.expression;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class OddTest {
    public static void main(String[] args) {
        for (int i = -19; i < 19; i++) {
            System.out.println(String.format("[%d] is odd?%s", i, isOdd(i)));
        }
    }

    /**
     * 对于负数取余数始终为负数
     *
     * @param i
     * @return
     */
    public static boolean isOdd(int i) {
        //return i % 2 == 1; error
        //return i % 2 != 0;
        return (i & 1) != 0;
    }
}

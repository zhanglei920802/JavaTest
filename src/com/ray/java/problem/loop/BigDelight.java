package com.ray.java.problem.loop;

/**
 * Created by 80107442 on 2017-01-03.
 */
public class BigDelight {
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90)
                System.out.print("Joy!");
        }
    }
}

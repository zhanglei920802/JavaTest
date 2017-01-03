package com.ray.java.problem.expression;

import com.ray.java.utils.Preconditions;

/**
 * Created by 80107442 on 2017-01-02.
 */
public class DosEquis {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        char x1 = true ? x : 0;
        Preconditions.checkArgument(x1 == x);
        System.out.println(x1);

        int x2 = false ? i : x;
        Preconditions.checkArgument(x2 == x);
        System.out.println(x2);
    }
}

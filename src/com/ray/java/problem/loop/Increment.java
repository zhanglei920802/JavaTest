package com.ray.java.problem.loop;

/**
 * 实际上输出的是0
 */
public class Increment {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            //这里会产生一个临时变量
            //等价于
//            int temp = j;
//            j = j + 1;
//            j = temp;
            j = j++;
        }
        System.out.println(j);
    }
}

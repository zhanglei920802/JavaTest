package com.ray.java.problem.class_confusing;

/**
 * 打印的确是Hello world,因为是静态的方法
 */
public class Null {
    public static void greet() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        ((Null) null).greet();
    }
}

package com.ray.java.problem.lib_string;

/**
 * Created by 80107442 on 2017-01-12.
 */
public class HaHa {
    public static void main(java.lang.String[] args) {
        String string = new String("dd");
        System.out.println(string);
    }
/**
 * 声明了String类就找不到main方法了,需要将main方法的参数改下
 */
static class String {
    private final java.lang.String s;

    public String(java.lang.String s) {
        this.s = s;
    }

    public java.lang.String toString() {
        return s;
    }
}
}

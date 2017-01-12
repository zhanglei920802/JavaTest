package com.ray.java.problem.class_confusing;

import java.util.Calendar;

/**
 * 通常，读取一个静态域是会引起一个类被初始化的事件之一，但是我们已经在初始化 Elvis 类了
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;
    //如果把这一行代码放在第一行，应该是没有问题的
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    /**
     * 在 final 类型的静态域被初始化之前，存在着读取它的值的可能，
     * 而此时该静态域包含的还只是其所属类型的缺省值。这是与直觉相违背的，因为
     * 我们通常会将 final 类型的域看作是常量。final 类型的域只有在其初始化表达
     * 式是常量表达式时才是常量[JLS 15.28]。
     */
    private Elvis() {
        //这里CURRENT_YEAR还未被初始化
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears a size " +
                INSTANCE.beltSize() + " belt.");
    }
}

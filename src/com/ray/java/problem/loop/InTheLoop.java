package com.ray.java.problem.loop;

/**
 * Created by 80107442 on 2017-01-04.
 */
//就会发现它压根就什么都没有打印。更糟的
//是，它会持续运行直到你撤销它为止
public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    //    问题在于这个循环会在循环索引（i）小于或等于 Integer.MAX_VALUE 时持续运
//    行，但是所有的 int 变量都是小于或等于 Integer.MAX_VALUE 的。因为它被定义
//    为所有 int 数值中的最大值。当 i 达到 Integer.MAX_VALUE，并且再次被执行增
//    量操作时，它就有绕回到了 Integer.MIN_VALUE
    public static void main(String[] args) {
        int count = 0;
        for (int i = START; i <= END; i++) {
            count++;
        }

        //修正
//        int i = START;
//        do {
//            count++;
//        }while (i++ != END);
        System.out.println(count);
    }
}

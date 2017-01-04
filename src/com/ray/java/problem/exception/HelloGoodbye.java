package com.ray.java.problem.exception;

/**
 * Created by 80107442 on 2017-01-04.
 */
public class HelloGoodbye {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world");
            //添加一个钩子函数
            Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Goodbye world")));
            System.exit(0);
        } finally {
            System.out.println("Goodbye world");
        }
    }
}

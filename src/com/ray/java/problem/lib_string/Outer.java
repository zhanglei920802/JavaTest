package com.ray.java.problem.lib_string;


import java.lang.reflect.Constructor;

/**
 * 如果那个 Class 对象“代表了一个抽象类（abstract class），一个接口
 * （interface），一个数组类（array class），一个原始类型（primitive type），
 * 或者是空（void）；或者这个类没有任何空的[也就是无参数的]构造器；或者实
 * 例化由于某些其他原因而失败，那么它就会抛出异常”[JAVA-API]。这里出现的
 * 问题满足上面的哪些条件呢？遗憾的是，异常信息没有提供任何提示。在这些条
 * 件中，只有后 2 个有可能会满足：要么是 Outer.Inner 没有空的构造器，要么是
 * 实例化由于“某些其它原因”而失败了
 */
public class Outer {
    public static void main(String[] args) throws Exception {
        new Outer().greetWorld();
    }

    private void greetWorld() throws Exception {
        //由于是非静态内部类，所以需要显式的将外部类的实例传入
        Constructor constructor = Inner.class.getConstructor(Outer.class);
        System.out.println(constructor.newInstance(Outer.this));
    }

    /**
     * 必须要有空的构造器
     */
    public class Inner {
        public String toString() {
            return "Hello world";
        }
    }
}

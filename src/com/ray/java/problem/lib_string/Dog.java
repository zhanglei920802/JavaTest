package com.ray.java.problem.lib_string;

/**
 * Created by 80107442 on 2017-01-13.
 */
public class Dog extends Exception{
    public static final Dog INSTANCE = new Dog();
    private Dog() {}
    public String toString(){
        return "Woof";
    }

    private Object readResolve(){
    // Accept no substitues!
        return INSTANCE;
    }
}

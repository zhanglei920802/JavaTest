package com.ray.java.problem.exception;

/**
 * Created by 80107442 on 2017-01-04.
 */
public class Indecisive {
    public static void main(String[] args) {
        System.out.println(decision());
    }

    static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}

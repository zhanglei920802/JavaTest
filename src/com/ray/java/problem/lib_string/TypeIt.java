package com.ray.java.problem.lib_string;

import com.ray.java.problem.expression.CodeTalk;
/**
 * 一个包内私有的方法不能被位
 * 于另一个包中的某个方法直接覆写[JLS 8.4.8]
 */
public class TypeIt {
    private static class ClickIt extends CodeTalk {
        void printMessage() {
            System.out.println("Hack");
        }
    }

    public static void main(String[] args) {
        ClickIt clickit = new ClickIt();
        clickit.doIt();
    }
}

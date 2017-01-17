package com.ray.java.problem.lib_string;

import java.io.PrintStream;

/**
 * Created by 80107442 on 2017-01-12.
 */
public class Greeter {
    public static void main(String[] args) {
        String greeting = "Hello World";
        for (int i = 0; i < greeting.length(); i++) {
            //out是带有缓冲区的
            PrintStream out = System.out;
            out.write(greeting.charAt(i));
            out.write('\n');
            out.flush();
        }
    }
}

package com.ray.java.problem.chartest;

import java.util.Random;

/**
 * Created by 80107442 on 2017-01-03.
 */

/**
 * 会将字符转为数字，从而调用了另外的构造函数
 */
public class Rhymes {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word = null;
        switch (rnd.nextInt(2)) {
            case 1:
                word = new StringBuffer('P');
            case 2:
                word = new StringBuffer('G');
            default:
                word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }
}

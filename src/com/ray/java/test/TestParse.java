package com.ray.java.test;

/**
 * Created by 80107442 on 2016-12-07.
 */
public class TestParse {
    public static void main(String[] args) {
        Long cityID = Long.parseLong(String.valueOf("-1"));
        System.out.println("cityID:" + cityID);
        System.out.println(-1L == cityID);
    }
}

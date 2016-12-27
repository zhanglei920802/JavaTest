package com.ray.java.collection;

import java.util.LinkedHashSet;

/**
 * Created by 80107442 on 2016-12-19.
 */
public class LinkedHashSetTest {
    public void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("LittleHann");
        System.out.println(books);

        //删除 Java
        books.remove("Java");
        //重新添加 Java
        books.add("Java");
        System.out.println(books);
    }
}

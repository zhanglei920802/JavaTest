package com.ray.java.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 80107442 on 2016-12-22.
 */
public class AsListTest {
    private static final String[] EMPTY_ARRAY = new String[0];

    public static void main(String[] args) {
//        int[] digists = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(Arrays.asList(digists));
//        System.out.println(Arrays.toString(digists));
        List<String> list = new ArrayList<String>() {{
            add("aaa");
            add("bbb");
            add("ccc");
            add("ddd");
        }};

        String[] array = list.toArray(EMPTY_ARRAY/*只是指定返回类型*/);
        System.out.println(Arrays.toString(array));
    }
}

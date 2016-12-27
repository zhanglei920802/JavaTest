package com.ray.oppo.test.list;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 80107442 on 2016-12-14.
 */
public class TextLineTest {
    private static final String WHITE_LIST = "whitelist.txt";

    private static ArrayList<Integer> mListData;
    private static TreeSet<Integer> mHashSet = new TreeSet<>();
    private static TreeMap<Integer, Object> mHashData = new TreeMap<>();
    private static Comparator mComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer lhs, Integer rhs) {
            if (lhs > rhs) {
                return 1;
            }
            else if (lhs < rhs) {
                return -1;
            }
            else {
                return 0;
            }
        }
    };

    public static void main(String[] args) {
//        FileReader reader = null;
//        try {
//            reader = loadInputStream();
//            loadListData(reader);
//        } finally {
//            if (null != reader) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//        //test
//        add("oppo.com".hashCode(),"dddd");
//        add("xiaojukeji.com".hashCode(),"dddd");
//        add("xiaojddukeji.com".hashCode(),"dddd");
//        add("xiaojukeji.com".hashCode(),"dddd");
//        add("xaojddukeji.com".hashCode(),"dddd");
//        add("xiajuji.com".hashCode(),"dddd");
//        add("xiaojdukeji.com".hashCode(),"dddd");
//        for (Integer iter : mHashData.keySet()) {
//            System.out.println(String.format("iter=" + iter));
//        }
//        String data = "shlottery.gov.cn";
//        String data2 = new String("shlottery.gov.cn");
//        System.out.println(String.format("data.code[%s],data2.code[%s]",data.hashCode(),data2.hashCode()));

        String url = "http://info.3g.qq.com/g/s?aid=index&g_ut=3&g_f=23875";
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com.cn|com|cn|net|org|biz|info|cc|tv)",Pattern
                .CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        System.out.println(matcher.group());
    }

    private static void add(int i) {
        mHashSet.add(i);
    }


    private static void add(int i, Object data) {
        mHashData.put(i, data);
    }

    private static boolean query(Integer s) {
        long begin = System.currentTimeMillis();
        int index = Collections.binarySearch(mListData, s, mComparator);
        boolean find = index >= 0;
        System.out.println(
                String.format("InWhiteList:find[%s],wasteTime[%d]", find, (System.currentTimeMillis() - begin)));
        return find;
    }

    private static FileReader loadInputStream() {
        FileReader read = null;
        try {
            read = new FileReader(WHITE_LIST);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return read;
    }

    private static void loadListData(FileReader reader) {
        char[] buffer = new char[4 * 1024];
        int n = 0;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = reader.read(buffer, 0, buffer.length)) != -1) {
                stringBuilder.append(buffer, 0, n);
            }
            String data = stringBuilder.toString();
            // System.out.println(String.format("data=[%s]", data));
            String[] arrays = data.split("\n");
            mListData = new ArrayList<>();
            for (int i = 0, len = arrays.length; i < len; i++) {
                mListData.add(arrays[i].hashCode());
            }
            Collections.sort(mListData, mComparator);
//
//            for (Integer iter : mListData) {
//                System.out.println("iter=" + iter);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

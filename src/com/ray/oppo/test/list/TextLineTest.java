package com.ray.oppo.test.list;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 80107442 on 2016-12-14.
 */
public class TextLineTest {
    private static final String WHITE_LIST = "whitelist.txt";

    private static ArrayList<String> mListData;

    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = loadInputStream();
            loadListData(reader);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //test
        query("oppo.com");
        query("xiaojukeji.com");
        query("xiaojddukeji.com");
    }

    private static void query(String s) {
        long begin = System.currentTimeMillis();
        //int index = mListData.indexOf(s);
        //int index = -1;
        boolean find = false;
        for (String iter : mListData) {
            if (s.contains(iter)) {
                find = true;
                break;
            }
        }
        long wasteTime = System.currentTimeMillis() - begin;
        System.out.println(String.format("query[%s] wasteTime[%d] hit[%s]", s, wasteTime, (find)));
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
                mListData.add(arrays[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

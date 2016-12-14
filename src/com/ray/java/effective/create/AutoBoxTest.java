package com.ray.java.effective.create;

import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 自动拆箱和装箱
 */
public class AutoBoxTest {
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();

        Long sum = 0L;//10872ms

        //long sum = 0L;//964ms
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            sum += i;
//        }
        System.out.print(String.format("costTime=[%d],sum[%d]", (System.currentTimeMillis() - beginTime), sum));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date date = sdf.parse("201512020519");
            Date pkDate = sdf.parse("201607010000");
            System.out.println("isOk:" + date.compareTo(pkDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

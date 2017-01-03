package com.ray.java.test;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将站点转为顶级域名，并除去重复值
 */
public class GetTopDomain {
    static final StringBuilder builder = new StringBuilder("[^.]*?\\.")
            .append("(gov.cn|com.cn|name|com.tw|co.id|co.jp|com.au|asia|com|ca|cn|net|org|biz|info|cc|tv)");
    static Pattern sTopAddressDomain = Pattern.compile(builder.toString(), Pattern.CASE_INSENSITIVE);
    public static final Pattern IP_ADDRESS
            = Pattern.compile(
            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9]))");

    static Set<String> arraySet = new HashSet<>();
    static List<String> sArrayListSet = new ArrayList<>();

    public static void main(String[] args) {
//        //1.将文件中的内容保存list中
//        parseList(sArrayListSet);
//        //2.读数据进行处理
//        processData(sArrayListSet, arraySet);
//        //3.写入文件
//        writeFile(arraySet);
        //(?<=http://|\.)[^.]*?\.(gov.cn|com.cn|.name|com|cn|net|org|biz|info|cc|tv)
        String host = "appledaily.com.tw";
        System.out.println(String.format("host[%s],topDomain[%s]", host,getTopDomain(host)));
    }

    private static void writeFile(Set<String> arraySet) {
        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("filtered_url.txt"));
            String data = join("\n", arraySet);
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void processData(List<String> arrayListSet, Set<String> out) {
        for (String iterm : arrayListSet) {
            String string = getTopDomain(iterm);
            System.out.println(string);
            out.add(string);
        }
    }

    private static void parseList(List<String> set) {
        Reader fileReader = null;
        try {
            fileReader = new FileReader(new File("oppo.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[8 * 1024];
            int len = 0;
            while ((len = fileReader.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len));
            }

            String[] content = stringBuilder.toString().split("\n");
            set.addAll(Arrays.asList(content));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 判断是否是IP地址
     *
     * @param host
     * @return
     */
    private static boolean isIpAddress(String host) {
        return IP_ADDRESS.matcher(host).matches();
    }

    /**
     * 获取顶级域名
     *
     * @return
     */
    public static String getTopDomain(String host) {
        try {
            if (isIpAddress(host)) {
                return host;
            }

            Matcher matcher = sTopAddressDomain.matcher(host);
            matcher.find();
            String topAddress = matcher.group(0);
            return topAddress;
        } catch (Exception e) {
            return host;
        }
    }

    public static String join(CharSequence delimiter, Iterable tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token : tokens) {
            if (firstTime) {
                firstTime = false;
            }
            else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }
}

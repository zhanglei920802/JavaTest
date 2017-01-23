package com.ray.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 传输数据：transTo,讲一个文件内容传输到另外一个文件
 */
public class TransToTest {
    public static void main(String[] args) {
        {
            RandomAccessFile fromFile = null;
            FileChannel fromChannel = null;
            RandomAccessFile toFile = null;
            FileChannel toChannel = null;
            try {
                fromFile = new RandomAccessFile("filtered_url.txt", "rw");
                fromChannel = fromFile.getChannel();//得到一个FileChannel
                toFile = new RandomAccessFile("tofiltered_url.txt", "rw");
                toChannel = toFile.getChannel();//得到一个FileChannel

                fromChannel.transferTo(0, fromChannel.size(), toChannel);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fromChannel != null && fromChannel.isOpen()) {
                    try {
                        fromChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (fromFile != null) {
                    try {
                        fromFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (toChannel != null && toChannel.isOpen()) {
                    try {
                        toChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (toFile != null) {
                    try {
                        toFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

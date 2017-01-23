package com.ray.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 80107442 on 2017-01-20.
 */
public class FileChanelWriteTest {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        FileChannel fileChannel = null;
        try {
            file = new RandomAccessFile("filtered_url.txt", "rw");
            fileChannel = file.getChannel();//得到一个FileChannel
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.put("1111ewewewoppo.com\n".getBytes());
            buffer.flip();//切换到写模式
            fileChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null && fileChannel.isOpen()) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

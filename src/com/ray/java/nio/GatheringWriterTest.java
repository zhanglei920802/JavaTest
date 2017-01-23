package com.ray.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 80107442 on 2017-01-20.
 */
public class GatheringWriterTest {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        FileChannel fileChannel = null;
        try {
            file = new RandomAccessFile("filtered_url.txt", "rw");
            fileChannel = file.getChannel();//得到一个FileChannel

            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            buffer1.put("buffer1.test\n".getBytes());
            ByteBuffer buffer2 = ByteBuffer.allocate(100);
            buffer2.put("buffer2.test\n".getBytes());
            buffer1.flip();//切换模式
            buffer2.flip();//切换模式

            fileChannel.write(new ByteBuffer[]{buffer1, buffer2});
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

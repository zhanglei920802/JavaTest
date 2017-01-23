package com.ray.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从一个Channel中读取数据到多个buffer
 */
public class ScatterReaderTest {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        FileChannel fileChannel = null;
        try {
            file = new RandomAccessFile("filtered_url.txt", "rw");
            fileChannel = file.getChannel();//得到一个FileChannel

            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            ByteBuffer buffer2 = ByteBuffer.allocate(100);

            int buffer1Read = -1;
            int buffer2Read = -1;
            PrintStream stream = System.out;
            do {
                buffer1.clear();
                buffer2.clear();

                buffer1Read = fileChannel.read(buffer1);
                buffer2Read = fileChannel.read(buffer2);

                buffer1.flip();
                buffer2.flip();

                stream.println("\nbuffer1=========");
                while (buffer1.hasRemaining()) {
                    stream.print((char) buffer1.get());
                }
                stream.println("\nbuffer2=========");
                while (buffer2.hasRemaining()) {
                    stream.print((char) buffer2.get());
                }
            } while (buffer1Read != -1 || buffer2Read != -1);

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

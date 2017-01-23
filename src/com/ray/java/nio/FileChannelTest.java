package com.ray.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 80107442 on 2017-01-20.
 */
public class FileChannelTest {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        FileChannel fileChannel = null;
        try {
            file = new RandomAccessFile("filtered_url.txt", "r");
            fileChannel = file.getChannel();//得到一个FileChannel
            ByteBuffer buffer = ByteBuffer.allocate(48);

            //读数据
            int bufferRead = fileChannel.read(buffer);
            PrintStream stream = System.out;
            while (bufferRead != -1) {

                //flip方法将Buffer从写模式切换到读模式
                buffer.flip();

                //读取buffer中的内容
                while (buffer.hasRemaining()) {
                    char item = (char) buffer.get();
                    stream.print(item);
                }

                buffer.clear();
                bufferRead = fileChannel.read(buffer);
            }

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

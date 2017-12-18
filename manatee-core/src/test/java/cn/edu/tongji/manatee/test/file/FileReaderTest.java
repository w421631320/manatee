package cn.edu.tongji.manatee.test.file;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xubing on 13:53 for manatee.
 * <p>
 * I love coding forever
 */

public class FileReaderTest {

    @Test
    public void DirectBufferTest() {
    }

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/xubing/Desktop/ids.txt", "r");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char)byteBuffer.get());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

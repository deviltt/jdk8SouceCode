package test.java.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{'a', 'b', 'c', 'd'};

        // 把 bytes 赋值给ByteArrayInputStream的缓冲数组
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes, 1, 2);

//        int i;  // 读出一个字节
//        while ((i = inputStream.read()) != -1) {
//            System.out.println((char) i);
//        }

        inputStream.skip(1);

        // skip 跳过一个字节
        System.out.println((char) inputStream.read());
    }
}

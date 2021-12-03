package test.java.copytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyTest {
    public static void main(String[] args) throws Exception {
        // 创建两个文件
//        ioCopy();

        channelCopy();
    }

    private static void ioCopy() throws Exception {
        File file = new File("D:\\developer.rar");
        File destFile = new File("D:\\test\\developer1.rar");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(destFile);

        byte[] bytes = new byte[1024];

        long currentTime = System.currentTimeMillis();
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - currentTime);

        inputStream.close();
        outputStream.close();
    }

    private static void channelCopy() throws Exception {
        File file = new File("D:\\developer.rar");
        File destFile = new File("D:\\test\\developer2.rar");

        FileChannel channel = new FileInputStream(file).getChannel();
        FileChannel destChannel = new FileOutputStream(destFile).getChannel();

        long currentTime = System.currentTimeMillis();
        channel.transferTo(0, channel.size(), destChannel);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - currentTime);

        channel.close();
        destChannel.close();
    }
}

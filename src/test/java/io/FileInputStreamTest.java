package test.java.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\bytes.txt");
        File file1 = new File("D:\\1.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        // 先写入文件
        byte[] bytes = new byte[]{0, 1, 2, 3, 4, 5};

        FileOutputStream outputStream = new FileOutputStream(file, true);

        outputStream.write(bytes, 0, bytes.length - 1);

        // 再读取文件
        FileInputStream inputStream = new FileInputStream(file);

        FileDescriptor fileDescriptor = inputStream.getFD();

        FileDescriptor fileDescriptor1 = new FileInputStream(file1).getFD();

        System.out.println(inputStream.getFD().valid());


        byte[] bytes1 = new byte[bytes.length];

        inputStream.skip(bytes.length);

        System.out.println(inputStream.available());

//        inputStream.read(bytes1, 3, 2);

        System.out.println(Arrays.toString(bytes1));
    }
}

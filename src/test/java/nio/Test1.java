package test.java.nio;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class Test1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.wrap(new byte[]{1,2,3});

        byteBuffer.position(2);
        byteBuffer.limit(2);
        byteBuffer.mark();

        byteBuffer.clear();

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());

        try {
            byteBuffer.reset();
        }catch (InvalidMarkException e){
            System.out.println(e.getMessage());
        }
    }
}

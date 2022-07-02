package test.java.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class AutomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(3);

        atomicInteger.getAndAccumulate(1, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        System.out.println(atomicInteger.get());
    }
}

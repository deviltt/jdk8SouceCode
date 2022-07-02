package test.java.util;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static class CountDownTask implements Runnable {
        private CountDownLatch countDownLatch;

        private long sleepTime;

        public CountDownTask(CountDownLatch countDownLatch, long sleepTime) {
            this.countDownLatch = countDownLatch;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("after %d s, thread countDown\n", sleepTime);
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new CountDownTask(countDownLatch, 1)).start();

        new Thread(new CountDownTask(countDownLatch, 2)).start();

        // 主线程阻塞，子线程进行扣减，减成0后，主线程放通
        // 主线程阻塞，等待子线程扣减
        System.out.println("main task blocked");
        countDownLatch.await();
    }
}

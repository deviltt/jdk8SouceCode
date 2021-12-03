package test.java.util;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);


        MyThread myThread1 = new MyThread(semaphore);

        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(myThread1, "tt" + i);
            thread.start();
        }
    }
}

class MyThread implements Runnable {
    private Semaphore semaphore;

    public MyThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            semaphore.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

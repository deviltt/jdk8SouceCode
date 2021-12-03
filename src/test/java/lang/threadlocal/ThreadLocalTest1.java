package test.java.lang.threadlocal;

public class ThreadLocalTest1 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();

        Thread.sleep(2000);

        myThread2.start();

        Thread.sleep(6000);
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            threadLocal.set(2);
            System.out.println(threadLocal.get());
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(threadLocal.get());
            System.out.println("ff");
        }
    }
}

package juc;

/**
 * 不使用锁，给定n个线程交替打印1-num个数
 *
 * @author edawrd
 * @version 1.0
 * @date 2025-04-21
 */
public class AlternatePrintWithoutLock {
    private static volatile int currentThreadId = 0;
    private static volatile int num = 0;
    private static int n;
    private static int M;

    static class PrintTask implements Runnable {
        private final int threadId;

        public PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (num <= M) {
                if (currentThreadId == threadId) {
                    if (num > M) break;
                    System.out.println("线程 " + threadId + ": " + num);
                    num++;
                    currentThreadId = (currentThreadId + 1) % n;
                } else {
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        n = 3;
        M = 5;
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new PrintTask(i));
            threads[i].start();
        }
        for (int i = 0; i < n; i++) {
            threads[i].join();
        }
    }
}
package practise.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: badgehu
 * @date: 2020/5/11 23:07
 * @description:
 */
public class Thread_ABC_Sync {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger lock = new AtomicInteger(0);
        Thread a = new Thread(new PrintThread(lock, "A", 0));
        Thread b = new Thread(new PrintThread(lock, "B", 1));
        Thread c = new Thread(new PrintThread(lock, "C", 2));
        a.start();
        b.start();
        c.start();
    }

    static class PrintThread implements Runnable {
        AtomicInteger count;
        int index;
        String name;

        PrintThread(AtomicInteger count, String name, int index) {
            this.count = count;
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (count) {
                    if (count.get() % 3 == index) {
                        System.out.println(name);
                        count.getAndIncrement();
                        count.notifyAll();
                        i++;//i++移除来，表示只有线程进入并打印才+1
                    } else {
                        try {
                            count.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}


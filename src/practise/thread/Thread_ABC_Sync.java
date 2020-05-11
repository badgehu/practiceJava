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
        int order;
        String name;

        PrintThread(AtomicInteger count, String name, int order) {
            this.count = count;
            this.name = name;
            this.order = order;
        }

        @Override
        public void run() {
            while (true){
                synchronized (count) {
                    // 当打印ABC连续十次退出
                    if (count.get() == 3*10){
                        break;
                    }
                    if (count.get() % 3 == order) {
                        System.out.println(name);
                        count.getAndIncrement();
                        count.notifyAll();
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

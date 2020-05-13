package practise.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author badgehu
 * @description: 多个线程顺序打印
 * @date 2020-05-13 09:58
 */
public class NThreadPrintNum {

    public static void main(String[] args) {
        Object lock = new Object();
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0;i<3;i++){
            new Thread(new NTreadPrint(lock,3,i,count)).start();
        }
    }

    static class NTreadPrint implements Runnable{
        private int index;
        private Object lock;
        private AtomicInteger count;
        private int threadCount;

        NTreadPrint(Object lock,int threadCount, int index, AtomicInteger count){
            this.lock = lock;
            this.index =index;
            this.threadCount = threadCount;
            this.count = count;
        }

        @Override
        public void run() {
            synchronized (lock){
                while (count.get() <= 100){
                    if(count.get() % threadCount == index){
                        System.out.println("线程"+index+":"+count.get());
                        lock.notifyAll();
                        count.getAndIncrement();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

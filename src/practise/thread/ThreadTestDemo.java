package practise.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-12 09:57
 */
public class ThreadTestDemo {
    static Thread t1,t2,t3;

    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread(()->{
            for (int i =0;i<10;i++){
                System.out.println("A");
                LockSupport.unpark(t2);
                LockSupport.park(t1);
            }
        });
        t2 = new Thread(()->{
            for (int i =0;i<10;i++){
                //LockSupport.unpark(t3);
                System.out.println("B");
                LockSupport.unpark(t3);
                LockSupport.park(t2);
            }
        });
        t3 = new Thread(()->{
            for (int i =0;i<10;i++){
               // LockSupport.unpark(t1);
                System.out.println("C");
                LockSupport.unpark(t1);
                LockSupport.park(t3);
            }
        });
        t1.start();
        // 保证线程顺序执行
        // 否则除了第一个线程，其他需要将upark()放在打印前，先进行阻塞
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
    }
}

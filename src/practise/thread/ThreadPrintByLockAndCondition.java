package practise.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: badgehu
 * @date: 2020/5/11 22:40
 * @description:
 */
public class ThreadPrintByLockAndCondition {
    public static void main(String[] args) {
         Lock lock = new ReentrantLock();
         Condition a = lock.newCondition();
         Condition b = lock.newCondition();
         Condition c = lock.newCondition();
        new Thread(()->{
            try{
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("A");
                    b.signal();
                    a.await();
                }
            }catch (Exception e){}finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try{
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("B");
                    c.signal();
                    b.await();
                }
            }catch (Exception e){}finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try{
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("C");
                    a.signal();
                    c.await();
                }
            }catch (Exception e){}finally {
                lock.unlock();
            }
        }).start();
    }
}

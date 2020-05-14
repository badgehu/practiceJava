package practise.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-14 10:12
 */
public class Bath3 {

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            if (i%2==0){
                new Thread(new Man("线程"+i)).start();
            }else {
                new Thread(new Woman("线程"+i)).start();
            }
        }
    }

    static Semaphore bathRoomSema = new Semaphore(3); //浴室资源
    static Semaphore sexSema = new Semaphore(1);  //性别锁
    static AtomicInteger manCount = new AtomicInteger(0);//当前浴室男人数量
    static AtomicInteger womanCount = new AtomicInteger(0);//当前浴室女人数量
    // 0：无人占用，1：男，2：女
    static AtomicInteger flag = new AtomicInteger(0);
    static class Man implements Runnable {
        String name;
        Man(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                 //不是男的标记就获取信号量
                if (flag.get() != 1) {
                    sexSema.acquire(); //获取性别信号量，禁止其他女生进来
                    flag.compareAndSet(0,1); //标记为男的
                }
                bathRoomSema.acquire();  // 获取浴室数量
                manCount.incrementAndGet();
                System.out.println(name + "男" +"洗澡");
                Thread.sleep(10);
                if (manCount.decrementAndGet() == 0) {
                    sexSema.release(); // 信号量打开，开放给女士用
                    flag.compareAndSet(1,0); //恢复为无人占用
                }
                bathRoomSema.release(); // 释放浴室资源
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Woman implements Runnable {
        String name;
        Woman(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                //不是女的标记就获取信号量
                if (flag.get() != 2) {
                    sexSema.acquire();
                    flag.compareAndSet(0,2); //设置为女的
                }
                bathRoomSema.acquire();
                womanCount.incrementAndGet();
                System.out.println(name + "女" +"洗澡");
                Thread.sleep(10);
                if (womanCount.decrementAndGet() == 0) {
                    sexSema.release(); // 信号量打开，开放给男士用
                    flag.compareAndSet(2,0); //恢复为无人占用
                }
                bathRoomSema.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
